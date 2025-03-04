package cashierfreestore.domain;

import java.time.LocalTime;
import cashierfreestore.domain.StoreAuthorityRegistered;
import cashierfreestore.domain.AnomalyDetected;
import cashierfreestore.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

import cashierfreestore.StoreApplication;
import lombok.Data;


@Entity
@Table(name="Store_table")
@Data

//<<< DDD / Aggregate Root
public class Store  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String userName;
    
    private String employeeIdCard;
    
    private Date enteringAt;
    
    private Date exitAt;
    
    private Date availableStartAt;
    
    private Date availableEndAt;
   
    @Embedded
    private UserId userId;
    
    @Enumerated(EnumType.STRING)
    private EnterStatus enterStatus;
    
    private String availableTime;

    public static StoreRepository repository(){
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(StoreRepository.class);
        return storeRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerStoreAuthority(UserAuthorityUpdated userAuthorityUpdated){
        
        //사용자 권한 수정 이벤트 발행시 등록된 정보와 매칭하여 매장 정보 등록 
        Store store = new Store();
        store.setUserId(new UserId(userAuthorityUpdated.getId()));
        store.setUserName(userAuthorityUpdated.getUserName());
        store.setEmployeeIdCard(userAuthorityUpdated.getEmployeeIdCard());
        store.setAvailableTime(userAuthorityUpdated.getAvailableTime());

        repository().save(store);

        StoreAuthorityRegistered storeAuthorityRegistered = new StoreAuthorityRegistered(store);
        storeAuthorityRegistered.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method


//<<< Clean Arch / Port Method
    public void enterStore(EnterStoreCommand enterStoreCommand){
        Date enteringDate = new Date();
        repository().findById(this.getId()).ifPresent(store ->{

            if(this.getEmployeeIdCard().equals(enterStoreCommand.getEmployeeIdCard())){
                if(this.getAvailableTime().equals("상시 가능")){
                    this.setEnterStatus(EnterStatus.ENTERED);
                    this.setEnteringAt(enteringDate);
                    this.setExitAt(null);

                    StoreEntered storeEntered = new StoreEntered(this);
                    storeEntered.publishAfterCommit();
                }else{
                    // 현재 시간과 이용가능 시간을 계산
                    LocalTime currentTime = LocalTime.now();
                    LocalTime availableTime = LocalTime.parse(this.getAvailableTime());
    
                    // 현재 시간이 getAvailableTime보다 작을 경우 무단입장 처리
                    if(currentTime.isBefore(availableTime)) {

                        //경고 상황 알림
                        cashierfreestore.external.Reservation reservation = new cashierfreestore.external.Reservation();
                        reservation.setTaskId(this.getId().toString());
                        reservation.setTitle("경고 상황");
                        reservation.setDescription("사원 " + this.getUserName() + "의 무단 입장 발생: 현재 시간 " + currentTime + "이 허용된 시간 " + availableTime + "보다 작습니다.");
                        reservation.setNow(true);

                        StoreApplication.applicationContext.getBean(cashierfreestore.external.ReservationService.class)
                            .createReservation(reservation);

                        this.setEnteringAt(enteringDate);

                        UnauthorizeEntered unauthorizeEntered = new UnauthorizeEntered(this);
                        unauthorizeEntered.publishAfterCommit();
                    }else{

                        this.setEnterStatus(EnterStatus.ENTERED);
                        this.setEnteringAt(enteringDate);
                        this.setExitAt(null);

                        StoreEntered storeEntered = new StoreEntered(this);
                        storeEntered.publishAfterCommit();
                    }
                }
            }
        });
    }
//>>> Clean Arch / Port Method

    public void exitStore(ExitStoreCommand exitStoreCommand){
        Date exitDate = new Date();
        repository().findById(this.getId()).ifPresent(store ->{
            
            this.setExitAt(exitDate);
            this.setEnterStatus(EnterStatus.EXITED);

            StoreExited storeExited = new StoreExited(this);
            storeExited.publishAfterCommit();
        });
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root

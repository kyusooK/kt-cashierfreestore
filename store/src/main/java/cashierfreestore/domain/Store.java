package cashierfreestore.domain;

import cashierfreestore.domain.StoreAuthorityRegistered;
import cashierfreestore.domain.AnomalyDetected;
import cashierfreestore.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


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
    public void enterStore(EnterStoreCommand enterStoreCommand){
        
        //implement business logic here:
        
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        cashierfreestore.external.Reservation reservation = new cashierfreestore.external.Reservation();
        // mappings goes here
        StoreApplication.applicationContext.getBean(cashierfreestore.external.ReservationService.class)
            .createReservation(reservation);


        cashierfreestore.external.StoreQuery storeQuery = new cashierfreestore.external.StoreQuery();
        // storeQuery.set??()        
          = StoreApplication.applicationContext
            .getBean(cashierfreestore.external.Service.class)
            .store(storeQuery);

        StoreEntered storeEntered = new StoreEntered(this);
        storeEntered.publishAfterCommit();
        UnauthorizeEntered unauthorizeEntered = new UnauthorizeEntered(this);
        unauthorizeEntered.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void exitStore(ExitStoreCommand exitStoreCommand){
        
        //implement business logic here:
        


        StoreExited storeExited = new StoreExited(this);
        storeExited.publishAfterCommit();
    }
//>>> Clean Arch / Port Method

//<<< Clean Arch / Port Method
    public static void registerStoreAuthority(UserAuthorityUpdated userAuthorityUpdated){
        
        //implement business logic here:
        
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        StoreAuthorityRegistered storeAuthorityRegistered = new StoreAuthorityRegistered(store);
        storeAuthorityRegistered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userAuthorityUpdated.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            StoreAuthorityRegistered storeAuthorityRegistered = new StoreAuthorityRegistered(store);
            storeAuthorityRegistered.publishAfterCommit();

         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root

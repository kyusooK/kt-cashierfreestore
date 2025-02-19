package cashierfreestore.domain;

import cashierfreestore.RecordingApplication;
import cashierfreestore.domain.EnteringHistoryRecorded;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "StoreUsing_table")
@Data
//<<< DDD / Aggregate Root
public class StoreUsing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date enteringDate;

    private Date exitDate;

    @Embedded
    private StoreId storeId;

    public static StoreUsingRepository repository() {
        StoreUsingRepository storeUsingRepository = RecordingApplication.applicationContext.getBean(
            StoreUsingRepository.class
        );
        return storeUsingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recordEnteringHistory(StoreEntered storeEntered) {

        StoreUsing storeUsing = new StoreUsing();
        storeUsing.setEnteringDate(storeEntered.getEnteringAt());
        storeUsing.setStoreId(new StoreId(storeEntered.getId()));
        repository().save(storeUsing);

        EnteringHistoryRecorded enteringHistoryRecorded = new EnteringHistoryRecorded(storeUsing);
        enteringHistoryRecorded.publishAfterCommit();


    }

    //<<< Clean Arch / Port Method
    public static void recordEnteringHistory(StoreExited storeExited) {
        
        
        ObjectMapper mapper = new ObjectMapper();
        Map<Long, Object> storeMap = mapper.convertValue(storeExited.getId(), Map.class);

        repository().findById(Long.valueOf(storeMap.get("id").toString())).ifPresent(storeUsing->{
            
            storeUsing.setExitDate(storeExited.getExitAt());
            repository().save(storeUsing);

            EnteringHistoryRecorded enteringHistoryRecorded = new EnteringHistoryRecorded(storeUsing);
            enteringHistoryRecorded.publishAfterCommit();

         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

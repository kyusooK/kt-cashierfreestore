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

    private String enteringDate;

    private String exitDate;

    @Embedded
    private StoreId storeId;

    @PostPersist
    public void onPostPersist() {
        EnteringHistoryRecorded enteringHistoryRecorded = new EnteringHistoryRecorded(
            this
        );
        enteringHistoryRecorded.publishAfterCommit();
    }

    public static StoreUsingRepository repository() {
        StoreUsingRepository storeUsingRepository = RecordingApplication.applicationContext.getBean(
            StoreUsingRepository.class
        );
        return storeUsingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recordEnteringHistory(StoreEntered storeEntered) {
        //implement business logic here:

        /** Example 1:  new item 
        StoreUsing storeUsing = new StoreUsing();
        repository().save(storeUsing);

        */

        /** Example 2:  finding and process
        
        // if storeEntered.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> storeMap = mapper.convertValue(storeEntered.getUserId(), Map.class);

        repository().findById(storeEntered.get???()).ifPresent(storeUsing->{
            
            storeUsing // do something
            repository().save(storeUsing);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recordEnteringHistory(StoreExited storeExited) {
        //implement business logic here:

        /** Example 1:  new item 
        StoreUsing storeUsing = new StoreUsing();
        repository().save(storeUsing);

        */

        /** Example 2:  finding and process
        
        // if storeExited.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> storeMap = mapper.convertValue(storeExited.getUserId(), Map.class);

        repository().findById(storeExited.get???()).ifPresent(storeUsing->{
            
            storeUsing // do something
            repository().save(storeUsing);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

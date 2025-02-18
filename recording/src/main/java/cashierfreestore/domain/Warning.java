package cashierfreestore.domain;

import cashierfreestore.RecordingApplication;
import cashierfreestore.domain.WarningSituationRecorded;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Warning_table")
@Data
//<<< DDD / Aggregate Root
public class Warning {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String warningRecord;

    public static WarningRepository repository() {
        WarningRepository warningRepository = RecordingApplication.applicationContext.getBean(
            WarningRepository.class
        );
        return warningRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recordWarningSituation(이상감지됨 이상감지됨) {
        //implement business logic here:

        /** Example 1:  new item 
        Warning warning = new Warning();
        repository().save(warning);

        WarningSituationRecorded warningSituationRecorded = new WarningSituationRecorded(warning);
        warningSituationRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if 이상감지됨.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> storeMap = mapper.convertValue(이상감지됨.getUserId(), Map.class);

        repository().findById(이상감지됨.get???()).ifPresent(warning->{
            
            warning // do something
            repository().save(warning);

            WarningSituationRecorded warningSituationRecorded = new WarningSituationRecorded(warning);
            warningSituationRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recordWarningSituation(StoreEntered storeEntered) {
        //implement business logic here:

        /** Example 1:  new item 
        Warning warning = new Warning();
        repository().save(warning);

        WarningSituationRecorded warningSituationRecorded = new WarningSituationRecorded(warning);
        warningSituationRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if storeEntered.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> storeMap = mapper.convertValue(storeEntered.getUserId(), Map.class);

        repository().findById(storeEntered.get???()).ifPresent(warning->{
            
            warning // do something
            repository().save(warning);

            WarningSituationRecorded warningSituationRecorded = new WarningSituationRecorded(warning);
            warningSituationRecorded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

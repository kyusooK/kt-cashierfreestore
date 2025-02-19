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
        
        Warning warning = new Warning();
        warning.setWarningRecord("cctv에 의해 이상상황이 감지되었습니다. cctv를 확인 바랍니다.");
        repository().save(warning);

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recordWarningSituation(
        UnauthorizeEntered unauthorizeEntered
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Warning warning = new Warning();
        repository().save(warning);

        WarningSituationRecorded warningSituationRecorded = new WarningSituationRecorded(warning);
        warningSituationRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if unauthorizeEntered.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> storeMap = mapper.convertValue(unauthorizeEntered.getUserId(), Map.class);

        repository().findById(unauthorizeEntered.get???()).ifPresent(warning->{
            
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

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
    public static void recordWarningSituation(AnomalyDetected anomalyDetected) {

        Warning warning = new Warning();
        warning.setWarningRecord("cctv에 의해 이상상황이 감지되었습니다 확인 바랍니다.");
        repository().save(warning);

        WarningSituationRecorded warningSituationRecorded = new WarningSituationRecorded(warning);
        warningSituationRecorded.publishAfterCommit();

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recordWarningSituation(
        UnauthorizeEntered unauthorizeEntered
    ) {
        //implement business logic here:

        Warning warning = new Warning();
        warning.setWarningRecord("무단 입장이 시도 되었습니다. 사원 이름: " + unauthorizeEntered.getUserName() + " 무단 입장 시간: " + unauthorizeEntered.getEnteringAt());
        repository().save(warning);

        WarningSituationRecorded warningSituationRecorded = new WarningSituationRecorded(warning);
        warningSituationRecorded.publishAfterCommit();
        
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

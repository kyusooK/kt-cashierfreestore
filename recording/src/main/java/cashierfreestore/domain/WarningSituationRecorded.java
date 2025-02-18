package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class WarningSituationRecorded extends AbstractEvent {

    private Long id;
    private String warningRecord;

    public WarningSituationRecorded(Warning aggregate) {
        super(aggregate);
    }

    public WarningSituationRecorded() {
        super();
    }
}
//>>> DDD / Domain Event

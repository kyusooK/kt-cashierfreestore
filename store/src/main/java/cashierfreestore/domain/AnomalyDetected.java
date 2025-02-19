package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AnomalyDetected extends AbstractEvent {

    private Long id;

    public AnomalyDetected(Store aggregate) {
        super(aggregate);
    }

    public AnomalyDetected() {
        super();
    }
}
//>>> DDD / Domain Event

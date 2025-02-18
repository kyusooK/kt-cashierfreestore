package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class EnteringHistoryRecorded extends AbstractEvent {

    private Long id;
    private StoreId storeId;
    private String enteringDate;
    private String exitDate;

    public EnteringHistoryRecorded(StoreUsing aggregate) {
        super(aggregate);
    }

    public EnteringHistoryRecorded() {
        super();
    }
}
//>>> DDD / Domain Event

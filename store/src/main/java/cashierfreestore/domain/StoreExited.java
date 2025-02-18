package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StoreExited extends AbstractEvent {

    private Long id;
    private String userName;
    private String employeeIdCard;
    private Date exitAt;
    private EnterStatus enterStatus;

    public StoreExited(Store aggregate) {
        super(aggregate);
    }

    public StoreExited() {
        super();
    }
}
//>>> DDD / Domain Event

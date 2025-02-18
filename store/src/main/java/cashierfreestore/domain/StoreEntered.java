package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StoreEntered extends AbstractEvent {

    private Long id;
    private String userName;
    private String employeeIdCard;
    private Date enteringAt;
    private EnterStatus enterStatus;

    public StoreEntered(Store aggregate) {
        super(aggregate);
    }

    public StoreEntered() {
        super();
    }
}
//>>> DDD / Domain Event

package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StoreAuthorityRegistered extends AbstractEvent {

    private Long id;
    private String userName;
    private String employeeIdCard;
    private String availableTime;

    public StoreAuthorityRegistered(Store aggregate) {
        super(aggregate);
    }

    public StoreAuthorityRegistered() {
        super();
    }
}
//>>> DDD / Domain Event

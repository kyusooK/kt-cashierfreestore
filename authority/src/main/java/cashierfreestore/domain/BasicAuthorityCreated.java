package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BasicAuthorityCreated extends AbstractEvent {

    private Long id;
    private String userName;
    private String availableTime;
    private String rank;
    private String department;

    public BasicAuthorityCreated(Authority aggregate) {
        super(aggregate);
    }

    public BasicAuthorityCreated() {
        super();
    }
}
//>>> DDD / Domain Event

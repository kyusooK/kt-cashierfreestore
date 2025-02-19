package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorityUpdated extends AbstractEvent {

    private Long id;
    private String availableTime;
    private String userName;

    public AuthorityUpdated(Authority aggregate) {
        super(aggregate);
    }

    public AuthorityUpdated() {
        super();
    }
}
//>>> DDD / Domain Event

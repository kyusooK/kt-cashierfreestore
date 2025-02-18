package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UserAuthorityUpdated extends AbstractEvent {

    private Long id;
    private String availableTime;
    private String userName;
    private String employeeIdCard;

    public UserAuthorityUpdated(User aggregate) {
        super(aggregate);
    }

    public UserAuthorityUpdated() {
        super();
    }
}
//>>> DDD / Domain Event

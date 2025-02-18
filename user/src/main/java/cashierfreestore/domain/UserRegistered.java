package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UserRegistered extends AbstractEvent {

    private Long id;
    private String userName;
    private String phoneNumber;
    private String rank;
    private String department;

    public UserRegistered(User aggregate) {
        super(aggregate);
    }

    public UserRegistered() {
        super();
    }
}
//>>> DDD / Domain Event

package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UnauthorizeEntered extends AbstractEvent {

    private Long id;
    private String userName;
    private String employeeIdCard;
    private Date enteringAt;

    public UnauthorizeEntered(Store aggregate) {
        super(aggregate);
    }

    public UnauthorizeEntered() {
        super();
    }
}
//>>> DDD / Domain Event

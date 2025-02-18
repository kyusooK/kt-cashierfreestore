package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class 이상감지됨 extends AbstractEvent {

    private Long id;

    public 이상감지됨(Store aggregate) {
        super(aggregate);
    }

    public 이상감지됨() {
        super();
    }
}
//>>> DDD / Domain Event

package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ChangedAuthorityRecorded extends AbstractEvent {

    private Long id;
    private String changingAuth;
    private AuthorityId authorityId;

    public ChangedAuthorityRecorded(AuthorityChaning aggregate) {
        super(aggregate);
    }

    public ChangedAuthorityRecorded() {
        super();
    }
}
//>>> DDD / Domain Event

package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UserAuthorityUpdated extends AbstractEvent {

    private Long id;
    private String availableTime;
    private String userName;
    private String employeeIdCard;
}

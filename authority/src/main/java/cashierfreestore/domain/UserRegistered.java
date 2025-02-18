package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UserRegistered extends AbstractEvent {

    private Long id;
    private String userName;
    private String phoneNumber;
    private String rank;
    private String department;
}

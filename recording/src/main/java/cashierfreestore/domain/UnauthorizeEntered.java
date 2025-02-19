package cashierfreestore.domain;

import cashierfreestore.domain.*;
import cashierfreestore.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UnauthorizeEntered extends AbstractEvent {

    private Long id;
    private String userName;
    private String employeeIdCard;
    private Date enteringAt;
}

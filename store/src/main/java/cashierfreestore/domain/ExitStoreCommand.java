package cashierfreestore.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ExitStoreCommand {

    private String employeeIdCard;
}

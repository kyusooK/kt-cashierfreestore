package cashierfreestore.domain;

import cashierfreestore.AuthorityApplication;
import cashierfreestore.domain.BasicAuthorityCreated;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Authority_table")
@Data
//<<< DDD / Aggregate Root
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String rank;

    private String department;

    private String availableTime;

    public static AuthorityRepository repository() {
        AuthorityRepository authorityRepository = AuthorityApplication.applicationContext.getBean(
            AuthorityRepository.class
        );
        return authorityRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateAuthority(UpdateAuthorityCommand updateAuthorityCommand) {
        //implement business logic here:

        AuthorityUpdated authorityUpdated = new AuthorityUpdated(this);
        authorityUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void createBasicAuthority(UserRegistered userRegistered) {

        Authority authority = new Authority();
        authority.setUserName(userRegistered.getUserName());
        authority.setRank(userRegistered.getRank());
        authority.setDepartment(userRegistered.getDepartment());

        repository().save(authority);

        BasicAuthorityCreated basicAuthorityCreated = new BasicAuthorityCreated(authority);
        basicAuthorityCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

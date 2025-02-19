package cashierfreestore.domain;

import cashierfreestore.UserApplication;
import cashierfreestore.domain.UserAuthorityUpdated;
import cashierfreestore.domain.UserRegistered;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String phoneNumber;

    private String employeeIdCard;

    private String rank;

    private String department;

    private String availableTime;

    @PostPersist
    public void onPostPersist() {
        UserRegistered userRegistered = new UserRegistered(this);
        userRegistered.publishAfterCommit();
    }

    public static UserRepository repository() {
        UserRepository userRepository = UserApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateUserAuthority(AuthorityUpdated authorityUpdated) {

        repository().findById(authorityUpdated.getId()).ifPresent(user->{
            
            user.setAvailableTime(authorityUpdated.getAvailableTime());
            repository().save(user);

            UserAuthorityUpdated userAuthorityUpdated = new UserAuthorityUpdated(user);
            userAuthorityUpdated.publishAfterCommit();

         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

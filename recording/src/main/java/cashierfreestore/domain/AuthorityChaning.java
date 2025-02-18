package cashierfreestore.domain;

import cashierfreestore.RecordingApplication;
import cashierfreestore.domain.ChangedAuthorityRecorded;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AuthorityChaning_table")
@Data
//<<< DDD / Aggregate Root
public class AuthorityChaning {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String changingAuth;

    @Embedded
    private AuthorityId authorityId;

    public static AuthorityChaningRepository repository() {
        AuthorityChaningRepository authorityChaningRepository = RecordingApplication.applicationContext.getBean(
            AuthorityChaningRepository.class
        );
        return authorityChaningRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recordChangedAuthority(
        AuthorityUpdated authorityUpdated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AuthorityChaning authorityChaning = new AuthorityChaning();
        repository().save(authorityChaning);

        ChangedAuthorityRecorded changedAuthorityRecorded = new ChangedAuthorityRecorded(authorityChaning);
        changedAuthorityRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(authorityUpdated.get???()).ifPresent(authorityChaning->{
            
            authorityChaning // do something
            repository().save(authorityChaning);

            ChangedAuthorityRecorded changedAuthorityRecorded = new ChangedAuthorityRecorded(authorityChaning);
            changedAuthorityRecorded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root

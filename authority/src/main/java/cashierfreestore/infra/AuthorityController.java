package cashierfreestore.infra;

import cashierfreestore.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/authorities")
@Transactional
public class AuthorityController {

    @Autowired
    AuthorityRepository authorityRepository;

    @RequestMapping(
        value = "/authorities/{id}/updateauthority",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Authority updateAuthority(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateAuthorityCommand updateAuthorityCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /authority/updateAuthority  called #####");
        Optional<Authority> optionalAuthority = authorityRepository.findById(
            id
        );

        optionalAuthority.orElseThrow(() -> new Exception("No Entity Found"));
        Authority authority = optionalAuthority.get();
        authority.updateAuthority(updateAuthorityCommand);

        authorityRepository.save(authority);
        return authority;
    }
}
//>>> Clean Arch / Inbound Adaptor

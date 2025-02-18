package cashierfreestore.infra;

import cashierfreestore.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuthorityChaningHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AuthorityChaning>> {

    @Override
    public EntityModel<AuthorityChaning> process(
        EntityModel<AuthorityChaning> model
    ) {
        return model;
    }
}

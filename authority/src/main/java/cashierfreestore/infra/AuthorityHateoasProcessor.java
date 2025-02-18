package cashierfreestore.infra;

import cashierfreestore.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuthorityHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Authority>> {

    @Override
    public EntityModel<Authority> process(EntityModel<Authority> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/updateauthority"
                )
                .withRel("updateauthority")
        );

        return model;
    }
}

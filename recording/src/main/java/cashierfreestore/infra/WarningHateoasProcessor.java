package cashierfreestore.infra;

import cashierfreestore.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class WarningHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Warning>> {

    @Override
    public EntityModel<Warning> process(EntityModel<Warning> model) {
        return model;
    }
}

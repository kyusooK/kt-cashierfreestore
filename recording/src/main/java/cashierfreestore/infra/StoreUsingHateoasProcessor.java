package cashierfreestore.infra;

import cashierfreestore.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StoreUsingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<StoreUsing>> {

    @Override
    public EntityModel<StoreUsing> process(EntityModel<StoreUsing> model) {
        return model;
    }
}

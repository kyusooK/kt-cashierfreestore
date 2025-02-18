package cashierfreestore.infra;

import cashierfreestore.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StoreHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Store>> {

    @Override
    public EntityModel<Store> process(EntityModel<Store> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/enterstore")
                .withRel("enterstore")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/exitstore")
                .withRel("exitstore")
        );

        return model;
    }
}

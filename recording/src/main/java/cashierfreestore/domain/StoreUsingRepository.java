package cashierfreestore.domain;

import cashierfreestore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "storeUsings",
    path = "storeUsings"
)
public interface StoreUsingRepository
    extends PagingAndSortingRepository<StoreUsing, Long> {}

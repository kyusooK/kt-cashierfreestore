package cashierfreestore.domain;

import cashierfreestore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface StoreRepository
    extends PagingAndSortingRepository<Store, Long> {}

package cashierfreestore.domain;

import cashierfreestore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "authorities",
    path = "authorities"
)
public interface AuthorityRepository
    extends PagingAndSortingRepository<Authority, Long> {}

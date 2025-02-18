package cashierfreestore.domain;

import cashierfreestore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "authorityChanings",
    path = "authorityChanings"
)
public interface AuthorityChaningRepository
    extends PagingAndSortingRepository<AuthorityChaning, Long> {}

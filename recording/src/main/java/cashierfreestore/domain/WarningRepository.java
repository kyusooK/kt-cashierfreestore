package cashierfreestore.domain;

import cashierfreestore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "warnings", path = "warnings")
public interface WarningRepository
    extends PagingAndSortingRepository<Warning, Long> {}

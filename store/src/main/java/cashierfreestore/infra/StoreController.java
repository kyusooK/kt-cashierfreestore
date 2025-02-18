package cashierfreestore.infra;

import cashierfreestore.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/stores")
@Transactional
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @RequestMapping(
        value = "/stores/{id}/enterstore",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store enterStore(
        @PathVariable(value = "id") Long id,
        @RequestBody EnterStoreCommand enterStoreCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/enterStore  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.enterStore(enterStoreCommand);

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "/stores/{id}/exitstore",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store exitStore(
        @PathVariable(value = "id") Long id,
        @RequestBody ExitStoreCommand exitStoreCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/exitStore  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.exitStore(exitStoreCommand);

        storeRepository.save(store);
        return store;
    }
}
//>>> Clean Arch / Inbound Adaptor

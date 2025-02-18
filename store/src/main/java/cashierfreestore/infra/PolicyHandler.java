package cashierfreestore.infra;

import cashierfreestore.config.kafka.KafkaProcessor;
import cashierfreestore.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    StoreRepository storeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UserAuthorityUpdated'"
    )
    public void wheneverUserAuthorityUpdated_RegisterStoreAuthority(
        @Payload UserAuthorityUpdated userAuthorityUpdated
    ) {
        UserAuthorityUpdated event = userAuthorityUpdated;
        System.out.println(
            "\n\n##### listener RegisterStoreAuthority : " +
            userAuthorityUpdated +
            "\n\n"
        );

        // Sample Logic //
        Store.registerStoreAuthority(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

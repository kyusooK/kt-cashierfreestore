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
    AuthorityRepository authorityRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UserRegistered'"
    )
    public void wheneverUserRegistered_CreateBasicAuthority(
        @Payload UserRegistered userRegistered
    ) {
        UserRegistered event = userRegistered;
        System.out.println(
            "\n\n##### listener CreateBasicAuthority : " +
            userRegistered +
            "\n\n"
        );

        // Sample Logic //
        Authority.createBasicAuthority(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

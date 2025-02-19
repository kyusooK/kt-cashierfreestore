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
    StoreUsingRepository storeUsingRepository;

    @Autowired
    AuthorityChaningRepository authorityChaningRepository;

    @Autowired
    WarningRepository warningRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AuthorityUpdated'"
    )
    public void wheneverAuthorityUpdated_RecordChangedAuthority(
        @Payload AuthorityUpdated authorityUpdated
    ) {
        AuthorityUpdated event = authorityUpdated;
        System.out.println(
            "\n\n##### listener RecordChangedAuthority : " +
            authorityUpdated +
            "\n\n"
        );

        // Sample Logic //
        AuthorityChaning.recordChangedAuthority(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='이상감지됨'"
    )
    public void whenever이상감지됨_RecordWarningSituation(
        @Payload 이상감지됨 이상감지됨
    ) {
        이상감지됨 event = 이상감지됨;
        System.out.println(
            "\n\n##### listener RecordWarningSituation : " + 이상감지됨 + "\n\n"
        );

        // Sample Logic //
        Warning.recordWarningSituation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UnauthorizeEntered'"
    )
    public void wheneverUnauthorizeEntered_RecordWarningSituation(
        @Payload UnauthorizeEntered unauthorizeEntered
    ) {
        UnauthorizeEntered event = unauthorizeEntered;
        System.out.println(
            "\n\n##### listener RecordWarningSituation : " +
            unauthorizeEntered +
            "\n\n"
        );

        // Sample Logic //
        Warning.recordWarningSituation(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StoreEntered'"
    )
    public void wheneverStoreEntered_RecordEnteringHistory(
        @Payload StoreEntered storeEntered
    ) {
        StoreEntered event = storeEntered;
        System.out.println(
            "\n\n##### listener RecordEnteringHistory : " +
            storeEntered +
            "\n\n"
        );

        // Sample Logic //
        StoreUsing.recordEnteringHistory(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StoreExited'"
    )
    public void wheneverStoreExited_RecordEnteringHistory(
        @Payload StoreExited storeExited
    ) {
        StoreExited event = storeExited;
        System.out.println(
            "\n\n##### listener RecordEnteringHistory : " + storeExited + "\n\n"
        );

        // Sample Logic //
        StoreUsing.recordEnteringHistory(event);
    }
}
//>>> Clean Arch / Inbound Adaptor

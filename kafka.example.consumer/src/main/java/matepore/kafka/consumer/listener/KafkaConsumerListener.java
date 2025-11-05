package matepore.kafka.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    // Listen to messages from the topic "matepore-topic" with group ID "matepore-group-id"
    @KafkaListener(topics = {"matepore-topic"}, groupId = "matepore-group-id")
    public void listener(String message){
        logger.info("Message received, the message is: {}", message);
    }
}

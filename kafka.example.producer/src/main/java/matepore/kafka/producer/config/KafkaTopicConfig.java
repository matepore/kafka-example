package matepore.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configs = new HashMap<>();
        configs.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // Set cleanup policy to delete
        configs.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Set retention to 1 day (in milliseconds)
        configs.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Set segment size to 1 GB
        configs.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1048576"); // Set max message size to 1 MB

        return TopicBuilder.name("matepore-topic")
                .partitions(2)
                .replicas(2)
                .configs(configs)
                .build();
    }
}

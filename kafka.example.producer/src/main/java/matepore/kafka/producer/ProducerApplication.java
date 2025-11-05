package matepore.kafka.producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProducerApplication {

    // SonarQube false positive: method body requires braces
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

    // Send a test message on application startup
    @Bean
    CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send("matepore-topic", "Final test of spring boot with kafka");
        };
    }
}

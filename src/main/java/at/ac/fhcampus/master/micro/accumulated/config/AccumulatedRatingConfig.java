package at.ac.fhcampus.master.micro.accumulated.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccumulatedRatingConfig {

    @Bean
    public Queue accumulatedRatingsWorkerQueue() {
        return new Queue("accumulated-ratings");
    }

}

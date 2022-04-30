package com.ikwattro.egrid.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicsConfig {

    private final int defaultPartitionsNumber = 1;
    private final short defaultReplicationFactor = 1;

    @Bean
    NewTopic deviceEventsTopic() {
        return new NewTopic("device-events", defaultPartitionsNumber, defaultReplicationFactor);
    }
}

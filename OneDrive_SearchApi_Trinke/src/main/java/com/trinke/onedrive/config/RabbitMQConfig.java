package com.trinke.onedrive.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    public static String qName="escar";

    @Bean
    public Queue createQueue() {
        return new Queue(qName);
    }

}

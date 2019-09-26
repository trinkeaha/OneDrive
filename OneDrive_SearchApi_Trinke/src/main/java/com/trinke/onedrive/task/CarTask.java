package com.trinke.onedrive.task;

import com.trinke.onedrive.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CarTask {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Scheduled(cron = "0/20 * * * * ?")
    public void exexMQ() {
        amqpTemplate.convertAndSend(RabbitMQConfig.qName,"同步ES开始："+System.currentTimeMillis()/1000);
    }
}

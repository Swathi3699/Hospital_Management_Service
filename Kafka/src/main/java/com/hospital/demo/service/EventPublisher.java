package com.hospital.demo.service;

import com.hospital.demo.entity.UserEvent;
import org.springframework.kafka.core.KafkaTemplate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;


@Service
public class EventPublisher {

    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    @Autowired
    public EventPublisher(KafkaTemplate<String, UserEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(UserEvent event) {
        kafkaTemplate.send("user-registration-events", event);
    }

    public void publishAppEvent(UserEvent event1) {
        kafkaTemplate.send("user-registration-events",event1);
    }

    public void publishBillEvent(UserEvent event2) {
        kafkaTemplate.send("user-registration-events",event2);
    }
}

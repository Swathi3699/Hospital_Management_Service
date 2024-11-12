package com.hospital.demo.service;

import com.hospital.demo.entity.UserEvent;
import org.apache.catalina.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaListener {

    @KafkaListener(topics = "user-registration-events", groupId = "notification-service-group")
    public void handleUserEvent(UserEvent event) {
        // Process the received event and send notification
        System.out.println("Received event: " + event);
    }

    @KafkaListener(topics = "user-registration-events",groupId = "notification-service-group")
    public void handleAppEvent(UserEvent event1){

        System.out.println("Received appointment event"+ event1);
    }

    @KafkaListener(topics = "user-registration-events", groupId = "notification-service-group")
    public void handleBillEvent(UserEvent event2){
        System.out.println("Received Bill event"+ event2);
    }
}




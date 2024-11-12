package com.hospital.demo.controller;

import com.hospital.demo.entity.UserEvent;
import com.hospital.demo.service.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final EventPublisher eventPublisher;

    @Autowired
    public KafkaController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishEvent(@RequestBody UserEvent userEvent) {
        eventPublisher.publishEvent(userEvent);
        return ResponseEntity.ok("User Event published successfully");
    }

    @PostMapping("/app")
    public ResponseEntity<String>publishAppEvent(@RequestBody UserEvent event1){
        eventPublisher.publishAppEvent(event1);
        return ResponseEntity.ok("Appointment Event published successfully");
    }

    @PostMapping("/billIssue")
    public ResponseEntity<String>publishBillEvent(@RequestBody UserEvent event2){
        eventPublisher.publishBillEvent(event2);
        return ResponseEntity.ok("Bill event published successfully");
    }
}
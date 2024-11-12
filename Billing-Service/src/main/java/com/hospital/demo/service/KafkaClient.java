package com.hospital.demo.service;

import com.hospital.demo.entity.UserEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(name = "kafka-service", url = "http://localhost:8082/kafka")
public interface KafkaClient {

    @PostMapping("/billIssue")
    void publishBillEvent(UserEvent event1);
}

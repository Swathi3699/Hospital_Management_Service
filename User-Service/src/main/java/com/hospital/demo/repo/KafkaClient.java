//package com.hospital.demo.repo;
//
//import com.hospital.demo.entity.UserEvent;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(name = "kafka-service",url = "http://localhost:8082/kafka")
//public interface KafkaClient {
//
//    @PostMapping("/publish")
//    void publishUserEvent(@RequestBody UserEvent event);
//}

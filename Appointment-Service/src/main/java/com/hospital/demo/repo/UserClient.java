//package com.hospital.demo.repo;
//
//
//import com.hospital.demo.entity.UserEvent;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name = "user-service",url = "http://localhost:8080/user")
//public interface UserClient {
//
//    @GetMapping("/user-event/{userId}")
//    UserEvent getUserEvent(@PathVariable Long userId);
//
//}

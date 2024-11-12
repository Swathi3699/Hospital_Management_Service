package com.hospital.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @RequestMapping("/userFallback")
    public String userFallback(){
        return "User Service is not running. Please try again later!";
    }
    @RequestMapping("/appFallback")
    public String appFallback(){
        return "Appointment Service is not running. Please try again later!";
    }
    @RequestMapping("/prescriptionFallback")
    public String prescriptionFallback(){
        return "Prescription Service is not running. Please try again later!";
    }
    @RequestMapping("/billFallback")
    public String billingFallback(){
        return "Billing Service is not running. Please try again later!";
    }
    @RequestMapping("/notificationFallback")
    public String notificationFallback(){
        return "Notification Service is not running. Please try again later!";
    }
}

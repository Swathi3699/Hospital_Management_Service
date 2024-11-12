package com.hospital.demo.controller;

import com.hospital.demo.entity.Notification;
import com.hospital.demo.service.NotificationListener;
import com.hospital.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/notifications")
    public ResponseEntity<Notification>createNotification(@RequestBody Notification notification){
        return notificationService.createNotification(notification);
    }

//    @PostMapping("/send/{notificationId}")
//    public ResponseEntity<String> sendNotification(@PathVariable Long notificationId,
//                                                   @RequestBody Notification notification){
//
//        return notificationListener.sendNotification(notificationId,notification);
//    }

    @GetMapping("/get/{notificationId}")
    public Optional<Notification> getNotification(@PathVariable Long notificationId){
        return notificationService.getNotification(notificationId);
    }

    @GetMapping("/getAll/{userId}")
    public List<Notification> getAllNotifications(@PathVariable Long userId){
        return notificationService.getAllNotifications(userId);

    }

    @PatchMapping("/patch/status/{notificationId}")
    public String updateStatus(@PathVariable long notificationId, @RequestBody String status){
        return notificationService.updateStatus(notificationId,status);
    }
}

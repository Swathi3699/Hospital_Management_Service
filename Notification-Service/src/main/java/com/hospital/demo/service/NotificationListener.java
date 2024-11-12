package com.hospital.demo.service;

import com.hospital.demo.entity.Email;
import com.hospital.demo.entity.Notification;
import com.hospital.demo.entity.UserEvent;
import com.hospital.demo.repo.NotificationRepo;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NotificationListener {

    @Autowired
    private EmailService emailService;

    @Autowired
    private NotificationRepo notificationRepo;

//    @Autowired
//    private SmsService smsService;

    @KafkaListener(topics = "user-registration-events",groupId = "notification-service-group")
    public void handleUserEvent(UserEvent event){
        System.out.println("Received event: " + event);

        try {
            String message=buildNotificationMessage(event);
            System.out.println(message);
//            sendNotification(event.getEmail(),
//                    event.getContactNumber(),"User-Registration", message);
//            logNotification(event, message, "EMAIL");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private String buildNotificationMessage(UserEvent event){
        if(event.getActionType().equals("REGISTER")){
            return "Welcome "+event.getFullName()+"! You have successfully registered.";
        }
        else if (event.getActionType().equals("UPDATE")){
            return "Hello "+event.getFullName()+"! Your profile has been updated";
        }
        else if (event.getActionType().equals("APPOINTMENT_BOOKED")) {
            return "Hi "+event.getFullName()+"! Your appointment got booked.Please check the details.";
        }
        else if (event.getActionType().equals("RESCHEDULED")){
            return "Hello "+event.getFullName()+"! Your appointment got rescheduled";
        } else if (event.getActionType().equals("GENERATED")) {
            return "Hello "+event.getFullName()+"! Your bill got generated.";
        }else if (event.getActionType().equals("SUCCESS")) {
            return "Hello " + event.getFullName() + "! Your payment was success.";
        }else if (event.getActionType().equals("FAILED")) {
            return "Hello " + event.getFullName() + "! Your payment was failed.Try again later.";
        }else if (event.getActionType().equals("PROCESSING")) {
            return "Hello " + event.getFullName() + "! Your payment is processing.Wait for some time.";
        }else {
            return "Hello";
        }
    }

//    private void sendNotification(String email,Long contactNumber,String subject,
//                                  String message) {
//
//        emailService.sendEmail(email,subject,message);
//
//    }

    public void logNotification(UserEvent event, String message, String channel) {
        Notification notification = new Notification();
        notification.setUserId(event.getUserId());
        notification.setNotificationType(event.getActionType());
        notification.setMessage(message);
        notification.setChannel(channel);
        notification.setStatus("SENT");
        notification.setSentAt(LocalDateTime.now());
        notificationRepo.save(notification);
    }


}

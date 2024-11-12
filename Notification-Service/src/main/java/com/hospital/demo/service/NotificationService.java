package com.hospital.demo.service;

import com.hospital.demo.entity.Notification;
import com.hospital.demo.repo.NotificationRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public ResponseEntity<Notification> createNotification(Notification notification) {
        Notification record=notificationRepo.save(notification);
        return ResponseEntity.ok(record);
    }



    public Optional<Notification> getNotification(Long notificationId) {
        return notificationRepo.findById(notificationId);
    }

    public List<Notification> getAllNotifications(Long userId) {
        List<Notification> records=notificationRepo.findAllByUserId(userId);
        return records;
    }

    public String updateStatus(long notificationId, String status) {
        Optional<Notification> existrecordOptional=notificationRepo.findById(notificationId);
        if(existrecordOptional.isPresent()){
            Notification existRecord=existrecordOptional.get();
            existRecord.setStatus(status);
            Notification updatedRecord= notificationRepo.save(existRecord);

            return "Updated Successfully";
        }
        else {
            return "Invalid notification ID";
        }
    }


}

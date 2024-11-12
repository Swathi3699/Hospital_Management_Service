package com.hospital.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long notificationId;
    private Long userId;
    private String notificationType;
    private String message;
    private String channel;
    private String status;
    private LocalDateTime sentAt;

}

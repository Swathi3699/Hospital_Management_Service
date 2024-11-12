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
public class Bill {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long billId;
    private Long userId;
    private Long patientId;
    private Long appointmentId;
    private double amountDue;
    private  String paymentStatus;
    private LocalDateTime paymentDueDate;
    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;
}

package com.hospital.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paymentH")
public class Payment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long paymentId;
    private Long billId;
    private Long userId;
    private Long patientId;
    private double amountPaid;
    private String paymentStatus;
    private Long transactionId;
    private LocalDateTime paymentDate;
}

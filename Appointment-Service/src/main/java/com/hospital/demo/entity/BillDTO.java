package com.hospital.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {

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

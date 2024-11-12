package com.hospital.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private Long userId;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime  appointmentDate;
    private String status;
    private String reasonForVisit;
    private LocalDateTime rescheduledDate;
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;

}

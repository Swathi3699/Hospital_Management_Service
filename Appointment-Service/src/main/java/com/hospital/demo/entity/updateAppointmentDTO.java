package com.hospital.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class updateAppointmentDTO {
    private Long userId;
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private String status;
    private LocalDateTime rescheduledDate;
    private LocalDateTime updatedAt;
}

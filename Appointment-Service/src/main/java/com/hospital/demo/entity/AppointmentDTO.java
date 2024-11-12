package com.hospital.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AppointmentDTO {

    private Long appointmentId;
    private Long patientID;
    private String status;
    private String reasonForVisit;
    private LocalDateTime appointmentDate;
}

package com.hospital.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PatientDTO {
    private Long patientId;
    private Long UserId;
    private String userName;
    private String password;
    private String fullName;
    private String role="PATIENT";
    private Long contactNumber;
    private String email;
    private String address;
    private Date dateOfBirth;
    private String medicalHistory;
    private String allergies;
    private String currentMedications;

}

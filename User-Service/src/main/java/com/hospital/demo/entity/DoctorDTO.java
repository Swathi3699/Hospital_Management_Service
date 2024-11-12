package com.hospital.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorDTO {
    private Long doctorId;
    private Long UserId;
    private String userName;
    private String password;
    private String fullName;
    private String role="DOCTOR";
    private Long contactNumber;
    private String email;
    private String address;
    private Date dateOfBirth;
    private String specialization;
    private String qualification;
    private int yearsOfExperience;
    private String clinicAddress;


}

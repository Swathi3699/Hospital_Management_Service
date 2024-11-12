package com.hospital.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private User user;
    private DoctorDTO doctorDTO;
    private PatientDTO patientDTO;
}

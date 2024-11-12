package com.hospital.demo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends User{

    private Long patientId;
    private String medicalHistory;
    private String allergies;
    private String currentMedications;

}

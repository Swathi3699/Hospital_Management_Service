package com.hospital.demo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends User{
    private Long doctorId;
    private String specialization;
    private String qualification;
    private int yearsOfExperience;
    private String clinicAddress;
}

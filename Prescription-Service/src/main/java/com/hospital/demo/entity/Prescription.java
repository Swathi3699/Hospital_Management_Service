package com.hospital.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private Long doctorId;
    private Long patientId;
    private Long appointmentId;
    @ElementCollection
    @CollectionTable(name = "prescription_medications",
            joinColumns = @JoinColumn(name = "prescriptionId"))
    private List<String> medications;
    private String diagnosis;
    private LocalDateTime createdAt;

}

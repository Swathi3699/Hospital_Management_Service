package com.hospital.demo.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Medications {
    private String name;
    private String dosage;
    private String frequency;
    private String duration;
}

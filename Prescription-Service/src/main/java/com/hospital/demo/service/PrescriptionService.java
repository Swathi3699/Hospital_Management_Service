package com.hospital.demo.service;

import com.hospital.demo.entity.Prescription;
import com.hospital.demo.repo.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepo repo;

    public ResponseEntity<Prescription> createPrescription(Prescription prescription) {
        Prescription record=repo.save(prescription);
        return ResponseEntity.ok(record);
    }

    public Optional<Prescription> getPrescription(Long patientId) {
        return repo.findById(patientId);
    }
}

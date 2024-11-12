package com.hospital.demo.controller;

import com.hospital.demo.entity.Prescription;
import com.hospital.demo.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService service;

    @PostMapping("/create")
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription){
        return  service.createPrescription(prescription);
    }

    @GetMapping("/get/{patientId}")
    public Optional<Prescription> getPrescription(@PathVariable Long patientId){
        return service.getPrescription(patientId);
    }
}

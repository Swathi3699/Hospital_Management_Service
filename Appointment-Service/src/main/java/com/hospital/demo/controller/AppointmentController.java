package com.hospital.demo.controller;

import com.hospital.demo.entity.*;
import com.hospital.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment){
        return service.bookAppointment(appointment);
    }

    @GetMapping("/get/{doctorID}")
    public ResponseEntity<List<AppointmentDTO>> getAppointments(@PathVariable Long doctorID){ // get appointments related to doctor
        List<AppointmentDTO> appointments=service.getAppointments(doctorID);
        if (appointments.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointments);
    }

    @PutMapping("/update/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long appointmentId,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime newDate,

                                                         @RequestBody updateAppointmentDTO updateDTO){
        return service.updateAppointments(appointmentId,updateDTO,newDate);

    }

    @PostMapping("/create/availDates")
    public ResponseEntity<DoctorAvailability>createAvailDates(@RequestBody DoctorAvailability availability){
        return service.createAvailDates(availability);
    }

    @PutMapping("/status/{appointmentId}")
    public ResponseEntity<Appointment> updateStatus(@PathVariable Long appointmentId, @RequestBody UpdateStatus updateStatus){
        return service.updateStatus(appointmentId,updateStatus);
    }
}

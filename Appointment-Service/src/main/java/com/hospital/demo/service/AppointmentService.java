package com.hospital.demo.service;

import com.hospital.demo.entity.*;
import com.hospital.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo repo;
    @Autowired
    private DoctorAvailRepo availRepo;

//    @Autowired
//    private UserClient userClient;

//    @Autowired
//    private KafkaClient kafkaClient;

    @Autowired
    private BillClient billClient;

    public ResponseEntity<Appointment> bookAppointment(Appointment appointment) {
        Appointment record= repo.save(appointment);

//        UserEvent event1= userClient.getUserEvent(appointment.getUserId());
//        System.out.println(event1);
//        event1.setActionType("APPOINTMENT_BOOKED");
//        kafkaClient.publishAppEvent(event1);
        return ResponseEntity.ok(record);
    }

    public List<AppointmentDTO> getAppointments(Long doctorID) {
        List<Appointment> appointments=repo.findByDoctorId(doctorID);

        return appointments.stream()
                .map(this::convertDTO)
                .collect(Collectors.toList());

    }

    private AppointmentDTO convertDTO(Appointment appointment){
        AppointmentDTO appointmentDTO=new AppointmentDTO();
        appointmentDTO.setAppointmentId(appointment.getAppointmentId());
        appointmentDTO.setPatientID(appointment.getPatientId());
        appointmentDTO.setStatus(appointment.getStatus());
        appointmentDTO.setReasonForVisit(appointment.getReasonForVisit());
        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
        return appointmentDTO;
    }

    public ResponseEntity<Appointment> updateAppointments(Long appointmentId,
                                                          updateAppointmentDTO updateDTO,LocalDateTime newDate) {

        Optional<Appointment>eAOptional=repo.findById(appointmentId);
        if(eAOptional.isPresent())
         {
            Appointment eAppointment=eAOptional.get();

            if(isDocAvailable(updateDTO.getDoctorId(),newDate))
             {

               eAppointment.setRescheduledDate(newDate);
               eAppointment.setUpdatedAt(newDate);


               eAppointment.setAppointmentId(updateDTO.getAppointmentId());
               eAppointment.setPatientId(updateDTO.getPatientId());
               eAppointment.setDoctorId(updateDTO.getDoctorId());
               eAppointment.setStatus(updateDTO.getStatus());


               Appointment updateRecord=repo.save(eAppointment);

//                 UserEvent event1= userClient.getUserEvent(updateDTO.getUserId());
//                 event1.setActionType("RESCHEDULED");
//                 System.out.println(event1);
//                 kafkaClient.publishAppEvent(event1);
               return ResponseEntity.ok(updateRecord);}
            else {
              return ResponseEntity.status(HttpStatus.CONFLICT)  // 409 Conflict
                      .body(null);}

        }
        else {
            return ResponseEntity.notFound().build();
    }
    }



    private boolean isDocAvailable(Long doctorId, LocalDateTime newDate) {
        List<DoctorAvailability> availRecords = availRepo.findByDoctorId(doctorId);

        for (DoctorAvailability availability : availRecords) {

            // Directly check if the availableDates list contains newDate
            if (availability.getAvailableDates().contains(newDate)) {
                return true;
            }
        }
        return false;
    }





    public ResponseEntity<DoctorAvailability> createAvailDates(DoctorAvailability availability) {
        DoctorAvailability records=availRepo.save(availability);
        return ResponseEntity.ok(records);
    }

    public ResponseEntity<Appointment> updateStatus(Long appointmentId, UpdateStatus updateStatus) {
        Optional<Appointment>existappointmentoptional=repo.findById(appointmentId);
        if(existappointmentoptional.isPresent()){
            Appointment existAppointment=existappointmentoptional.get();
            existAppointment.setStatus("Completed");
            Appointment updatedRecords=repo.save(existAppointment);
            System.out.println(updateStatus.getBillDTO());

            if(updatedRecords.getStatus().equals("Completed")){
                billClient.createBill(updateStatus.getBillDTO(),existAppointment.getAppointmentId());
            }

            return ResponseEntity.ok(updatedRecords);

        }
       return ResponseEntity.notFound().build();

    }
}

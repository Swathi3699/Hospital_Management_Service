package com.hospital.demo.service;

import com.hospital.demo.entity.*;
//import com.hospital.demo.repo.KafkaClient;
import com.hospital.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private KafkaClient kafkaClient;

    public Optional<User> getUserById(Long userId) {
        return userRepo.findById(userId);
    }

    public ResponseEntity<User> updateUser(Long userId, User user) {
        Optional<User> existingUserOptional = userRepo.findById(userId);
        System.out.println(existingUserOptional);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            System.out.println(existingUser);
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());
            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());
            existingUser.setContactNumber(user.getContactNumber());
            existingUser.setDateOfBirth(user.getDateOfBirth());
            existingUser.setRole(user.getRole());
            existingUser.setAddress(user.getAddress());

//            UserEvent event=new UserEvent(user.getUserId(),
//                    user.getFullName(), user.getRole(),
//                    user.getContactNumber(),
//                    user.getEmail(), "UPDATE");
//            kafkaClient.publishUserEvent(event);

            User updatedRecords = userRepo.save(existingUser);
            return ResponseEntity.ok(updatedRecords);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<User> updateDoctorDetails(Long userId, DoctorDTO doctorDTO) {
        Doctor doctor=userRepo.findById(userId)
                              .filter(Doctor.class::isInstance)
                             .map(Doctor.class::cast)
                             .orElseThrow(()->new IllegalArgumentException("Doctor not found"));

        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setQualification(doctorDTO.getQualification());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.setClinicAddress(doctorDTO.getClinicAddress());

//        UserEvent event=new UserEvent(doctorDTO.getUserId(),
//                doctorDTO.getFullName(), doctorDTO.getRole(),
//                doctorDTO.getContactNumber(),
//                doctorDTO.getEmail(), "UPDATE");
//        kafkaClient.publishUserEvent(event);
          Doctor updatedDoctor=userRepo.save(doctor);
          return ResponseEntity.ok(updatedDoctor);

    }

    public ResponseEntity<User> updatePatientDetails(Long userId, PatientDTO patientDTO) {
        Patient patient=userRepo.findById(userId)
                                 .filter(Patient.class::isInstance)
                                  .map(Patient.class::cast)
                                   .orElseThrow(()->new IllegalArgumentException("Patient not found"));

        patient.setMedicalHistory(patientDTO.getMedicalHistory());
        patient.setAllergies(patientDTO.getAllergies());
        patient.setCurrentMedications(patientDTO.getCurrentMedications());

//        UserEvent event=new UserEvent(patientDTO.getUserId(),
//                patientDTO.getFullName(), patientDTO.getRole(),
//                patientDTO.getContactNumber(),
//                patientDTO.getEmail(), "UPDATE");
//        kafkaClient.publishUserEvent(event);

         Patient updatedPatient=userRepo.save(patient);
        return ResponseEntity.ok(updatedPatient);

    }

    public Doctor registerDoctor(DoctorDTO doctorDTO) {
        Doctor doctor=new Doctor();
        doctor.setUserName(doctorDTO.getUserName());
        doctor.setPassword(doctorDTO.getPassword());
        doctor.setFullName(doctorDTO.getFullName());
        doctor.setContactNumber(doctorDTO.getContactNumber());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setDateOfBirth(doctorDTO.getDateOfBirth());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setQualification(doctorDTO.getQualification());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.setClinicAddress(doctorDTO.getClinicAddress());
        doctor.setRole(doctorDTO.getRole());
        doctor.setDoctorId(doctorDTO.getDoctorId());


//        UserEvent event=new UserEvent(doctorDTO.getUserId(),
//                doctorDTO.getFullName(), doctorDTO.getRole(),
//                doctorDTO.getContactNumber(),
//                doctorDTO.getEmail(), "REGISTER");
//        kafkaClient.publishUserEvent(event);
        return userRepo.save(doctor);

    }

    public Patient registerPatient(PatientDTO patientDTO) {

        Patient patient=new Patient();
        patient.setUserName(patientDTO.getUserName());
        patient.setPassword(patientDTO.getPassword());
        patient.setFullName(patientDTO.getFullName());
        patient.setContactNumber(patientDTO.getContactNumber());
        patient.setEmail(patientDTO.getEmail());
        patient.setAddress(patientDTO.getAddress());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setMedicalHistory(patientDTO.getMedicalHistory());
        patient.setAllergies(patientDTO.getAllergies());
        patient.setCurrentMedications(patientDTO.getCurrentMedications());
        patient.setRole(patientDTO.getRole());
        patient.setPatientId(patientDTO.getPatientId());

//        UserEvent event=new UserEvent(patientDTO.getUserId(),
//                patientDTO.getFullName(), patientDTO.getRole(),
//                patientDTO.getContactNumber(),
//                patientDTO.getEmail(), "REGISTER");
//        kafkaClient.publishUserEvent(event);

        return userRepo.save(patient);
    }

    public boolean doLogin(String userName, String password) {
        Optional<User>optionalUser=Optional.ofNullable(userRepo.findByUserName(userName));
        if(optionalUser.isPresent()){
            User user=optionalUser.get();
            return user.getPassword().equals(password);

        }
        return false;
    }


    public ResponseEntity<Optional<UserEvent>> getUserEvent(Long userId) {
        Optional<User> existUser=userRepo.findById(userId);
        System.out.println(existUser);
        Optional<UserEvent> userEvent=existUser.map(this::convertEvent);

        System.out.println("User Event"+ userEvent);
        return ResponseEntity.ok(userEvent);
    }

    private UserEvent convertEvent(User user1){
        UserEvent presentUser=new UserEvent();
        presentUser.setUserId(user1.getUserId());
        presentUser.setFullName(user1.getFullName());
        presentUser.setRole(user1.getRole());
        presentUser.setContactNumber(user1.getContactNumber());
        presentUser.setEmail(user1.getEmail());
        return presentUser;
    }
}

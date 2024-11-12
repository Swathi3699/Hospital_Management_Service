package com.hospital.demo.controller;

import com.hospital.demo.entity.*;
import com.hospital.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user-event/{userId}")
    public ResponseEntity<Optional<UserEvent>> getUserEvent(@PathVariable Long userId){
        return userService.getUserEvent(userId);
    }

    @PostMapping("/register/doctor")
    public ResponseEntity<Doctor>registerDoctor(@RequestBody DoctorDTO doctorDTO){
        Doctor savedDoctor=userService.registerDoctor(doctorDTO);
        return ResponseEntity.ok(savedDoctor);

    }
    @PostMapping("/register/patient")
    public ResponseEntity<Patient>registerDoctor(@RequestBody PatientDTO patientDTO){
        Patient savedPatient=userService.registerPatient(patientDTO);
        return ResponseEntity.ok(savedPatient);

    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody User loginRequest){
        boolean isAuthenticated= userService.doLogin(loginRequest.getUserName(), loginRequest.getPassword());
        if(isAuthenticated){
            return ResponseEntity.ok("Login Successfully");
        }else {
        return ResponseEntity.status(401).body("Invalid username and password");
    }}

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId,
                                             @RequestBody UpdateUserRequest request){

        User user=request.getUser();
        DoctorDTO doctorDTO= request.getDoctorDTO();
        PatientDTO patientDTO= request.getPatientDTO();

        ResponseEntity<User> updatedUser= userService.updateUser(userId,user);
        System.out.println(updatedUser);

        if("DOCTOR".equalsIgnoreCase(user.getRole()) && doctorDTO!=null){
            updatedUser=userService.updateDoctorDetails(userId,doctorDTO);
        } else if ("PATIENT".equalsIgnoreCase(user.getRole()) && patientDTO!=null) {
            updatedUser=userService.updatePatientDetails(userId,patientDTO);
        }else {
            return ResponseEntity.badRequest().body("Invalid role or missing role-specific details");
        }

        return ResponseEntity.ok(updatedUser);
    }


}

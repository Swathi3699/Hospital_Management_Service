package com.hospital.demo.repo;

import com.hospital.demo.entity.Appointment;
import com.hospital.demo.entity.AppointmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctorId(Long doctorID);
}

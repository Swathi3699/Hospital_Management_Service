package com.hospital.demo.repo;

import com.hospital.demo.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorAvailRepo extends JpaRepository<DoctorAvailability,Long> {

    List<DoctorAvailability> findByDoctorId(Long doctorId);
}

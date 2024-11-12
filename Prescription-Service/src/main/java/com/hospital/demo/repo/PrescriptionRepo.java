package com.hospital.demo.repo;

import com.hospital.demo.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription,Long> {
}

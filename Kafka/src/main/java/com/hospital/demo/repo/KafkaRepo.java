package com.hospital.demo.repo;

import com.hospital.demo.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepo extends JpaRepository<UserEvent,Long> {
}

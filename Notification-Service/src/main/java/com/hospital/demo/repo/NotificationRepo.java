package com.hospital.demo.repo;

import com.hospital.demo.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Long> {

    List<Notification> findAllByUserId(Long userId);
}

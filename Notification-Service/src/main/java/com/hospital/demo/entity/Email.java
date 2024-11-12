package com.hospital.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    private String emailId;
    private String recipient;
    private String subject;
    private String body;
    private LocalDateTime sentAt;
}

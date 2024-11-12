package com.hospital.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    @Id
    private Long UserId;
    private String fullName;
    private String role;
    private Long contactNumber;
    private String email;
    private String actionType;


}

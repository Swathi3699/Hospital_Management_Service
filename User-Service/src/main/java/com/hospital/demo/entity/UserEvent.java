package com.hospital.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    private Long UserId;
    private String fullName;
    private String role;
    private Long contactNumber;
    private String email;
    private String actionType;
}

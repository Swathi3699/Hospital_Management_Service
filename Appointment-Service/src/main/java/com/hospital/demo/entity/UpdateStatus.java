package com.hospital.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatus {
    private updateAppointmentDTO update;
    private BillDTO billDTO;
}

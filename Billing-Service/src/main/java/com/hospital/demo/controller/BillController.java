package com.hospital.demo.controller;

import com.hospital.demo.entity.Bill;
import com.hospital.demo.entity.BillDTO;
import com.hospital.demo.entity.Payment;
import com.hospital.demo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/issue/{appointmentId}")
    public ResponseEntity<Bill> createBill(@RequestBody BillDTO billDTO, @PathVariable Long appointmentId){
        System.out.println(billDTO);
        Bill bill=convertBill(billDTO);
        return billService.createBill(bill);
    }

    private Bill convertBill(BillDTO billDTO){
        Bill b=new Bill();
        b.setBillId(billDTO.getBillId());
        b.setUserId(billDTO.getUserId());
        b.setPatientId(billDTO.getPatientId());
        b.setAppointmentId(billDTO.getAppointmentId());
        b.setAmountDue(billDTO.getAmountDue());
        b.setPaymentStatus(billDTO.getPaymentStatus());
        b.setPaymentDate(billDTO.getPaymentDate());
        b.setPaymentDueDate(billDTO.getPaymentDueDate());
        b.setCreatedAt(billDTO.getCreatedAt());
        return b;
    }
    @GetMapping("/getBill/{patientId}")
    public Optional<Bill> getBill(@PathVariable Long patientId){
        return billService.getBill(patientId);
    }

    @PostMapping("/process")
    public ResponseEntity<Payment>processPayment(@RequestBody Payment payment){
        return billService.processPayment(payment);
    }

}

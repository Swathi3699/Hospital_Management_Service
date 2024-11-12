package com.hospital.demo.service;

import com.hospital.demo.entity.Bill;
import com.hospital.demo.entity.BillDTO;
import com.hospital.demo.entity.Payment;
import com.hospital.demo.entity.UserEvent;
import com.hospital.demo.repo.BillRepo;
import com.hospital.demo.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private UserClient userClient;

    @Autowired
    private KafkaClient kafkaClient;

    public ResponseEntity<Bill> createBill(Bill bill) {
        Bill newBill=billRepo.save(bill);

        System.out.println(newBill);
        UserEvent event1=userClient.getUserEvent(bill.getUserId());
        event1.setActionType("GENERATED");
        System.out.println(event1);
        kafkaClient.publishBillEvent(event1);
        return ResponseEntity.ok(newBill);
    }



    public Optional<Bill> getBill(Long patientId) {
        return billRepo.findById(patientId);
    }

    public ResponseEntity<Payment> processPayment(Payment payment) {
        Payment payment1=paymentRepo.save(payment);
        UserEvent event1=userClient.getUserEvent(payment.getUserId());
        event1.setActionType(getRandomActionType());
        System.out.println(event1);
        kafkaClient.publishBillEvent(event1);
        return ResponseEntity.ok(payment1);
    }

    private String getRandomActionType(){
        String actionType[]={"SUCCESS","FAILED","PROCESSING"};
        Random random=new Random();
        int randomIndex=random.nextInt(actionType.length);
        return actionType[randomIndex];
    }
}

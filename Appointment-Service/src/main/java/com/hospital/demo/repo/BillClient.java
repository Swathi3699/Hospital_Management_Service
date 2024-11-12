package com.hospital.demo.repo;

import com.hospital.demo.entity.BillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "bill-service",url = "http://localhost:6060/bill")
public interface BillClient {

    @PostMapping("/issue/{appointmentId}")
    void createBill(@RequestBody BillDTO billDTO, @PathVariable("appointmentId") Long appointmentId);
}


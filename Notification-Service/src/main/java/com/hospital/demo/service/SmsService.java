//package com.hospital.demo.service;
//
//import com.twilio.type.PhoneNumber;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SmsService {
//
//    // Make sure to configure your Twilio credentials and initialize Twilio
//    // This should ideally be done in a configuration class
//    static {
//        // Twilio.init(ACCOUNT_SID, AUTH_TOKEN); // Uncomment and use your Twilio credentials
//    }
//
//    public void sendSms(Long contactNumber, String message) {
//        // Convert Long contact number to String
//        String phoneNumber = contactNumber.toString();
//
//        // Create and send the message
//        Message.creator(
//                new PhoneNumber(phoneNumber), // Recipient's phone number
//                new PhoneNumber("your_twilio_number"), // Your Twilio number
//                message // Message body
//        ).create();
//    }
//}
//
//

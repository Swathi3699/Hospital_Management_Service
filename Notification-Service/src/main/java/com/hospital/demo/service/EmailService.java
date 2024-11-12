package com.hospital.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;



    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendEmail(String email, String subject, String message) {
        SimpleMailMessage message1 = new SimpleMailMessage();
        message1.setTo(email);
        message1.setSubject(subject);
       message1.setText(message);
       mailSender.send(message1);

    }

}

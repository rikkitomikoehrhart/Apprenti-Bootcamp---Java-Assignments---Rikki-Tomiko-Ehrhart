package com.example.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class XmlNotificationService {
    private final EmailService emailService;

    @Autowired
    public NotificationService(@Qualifier("gmailService") EmailService emailService) {
        this.emailService = emailService;
    }

    public void send(String message) {
        System.out.println("XMLNotification Service: Sending message to interface implementation...");
        emailService.sendEmail(message);
    }
}

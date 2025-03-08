package com.example.week9example1.service.notification;


public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String recipient, String subject, String message) {
        // Code to send email notification
        System.out.println("Sending email to " + recipient + " with subject: " + subject);
    }
}

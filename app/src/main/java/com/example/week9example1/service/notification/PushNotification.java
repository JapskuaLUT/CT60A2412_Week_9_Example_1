package com.example.week9example1.service.notification;

import android.content.Context;

public class PushNotification implements NotificationService {
    private Context context;

    public PushNotification(Context context) {
        this.context = context;
    }

    @Override
    public void sendNotification(String recipient, String subject, String message) {
        // Code to send push notification using Firebase Cloud Messaging or similar
        System.out.println("Sending push notification to " + recipient + ": " + message);
    }
}

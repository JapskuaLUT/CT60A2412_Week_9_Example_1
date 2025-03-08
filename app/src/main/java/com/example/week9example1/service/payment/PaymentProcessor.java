package com.example.week9example1.service.payment;

public interface PaymentProcessor {
    boolean processPayment(String orderId, double amount);
    void cancelPayment(String paymentId);
}

package com.example.week9example1.service.payment;

public class PayPalPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(String orderId, double amount) {
        // Implementation for PayPal payment
        System.out.println("Processing PayPal payment for order " + orderId +
                " amount: $" + amount);
        return true;
    }

    @Override
    public void cancelPayment(String paymentId) {
        System.out.println("Cancelling PayPal payment: " + paymentId);
    }
}
package com.example.week9example1.service.payment;

public class CreditCardPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(String orderId, double amount) {
        // Implementation for credit card payment
        System.out.println("Processing credit card payment for order " + orderId +
                " amount: $" + amount);
        return true;
    }

    @Override
    public void cancelPayment(String paymentId) {
        System.out.println("Cancelling credit card payment: " + paymentId);
    }
}
package com.example.week9example1.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.week9example1.R;
import com.example.week9example1.model.Product;
import com.example.week9example1.service.discount.DiscountStrategy;
import com.example.week9example1.service.discount.PercentageDiscount;
import com.example.week9example1.service.notification.EmailNotification;
import com.example.week9example1.service.notification.NotificationService;
import com.example.week9example1.service.payment.CreditCardPayment;
import com.example.week9example1.service.payment.PaymentProcessor;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {
    // Demonstrate Dependency Inversion
    private PaymentProcessor paymentProcessor;
    private NotificationService notificationService;
    private DiscountStrategy discountStrategy;
    private List<Product> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Initialize with specific implementations
        // In a real app, these would be injected through a DI framework like Dagger
        paymentProcessor = new CreditCardPayment();
        notificationService = new EmailNotification();
        discountStrategy = new PercentageDiscount(10); // 10% discount
        cartItems = new ArrayList<>(); // Would be populated from cart

        setupCheckoutButton();
    }

    private void setupCheckoutButton() {
        // findViewById(R.id.checkout_button).setOnClickListener(v -> {
        //     processCheckout();
        // });
    }

    private void processCheckout() {
        double total = calculateTotal();

        String orderId = "ORD-" + System.currentTimeMillis();
        boolean paymentSuccess = paymentProcessor.processPayment(orderId, total);

        if (paymentSuccess) {
            String userEmail = "customer@example.com"; // In real app, get from user account
            notificationService.sendNotification(
                    userEmail,
                    "Order Confirmation",
                    "Your order #" + orderId + " has been processed successfully."
            );

            // Clear cart and navigate to order confirmation
            // ...
        } else {
            // Handle payment failure
            // ...
        }
    }

    private double calculateTotal() {
        double subtotal = 0;
        for (Product product : cartItems) {
            subtotal += product.getPrice();
        }

        // Apply discount
        return discountStrategy.applyDiscount(subtotal);
    }
}
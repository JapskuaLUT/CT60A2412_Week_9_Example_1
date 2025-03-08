package com.example.week9example1.service.discount;

public class FixedAmountDiscount extends DiscountStrategy {
    private double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double price) {
        return Math.max(0, price - amount);
    }
}

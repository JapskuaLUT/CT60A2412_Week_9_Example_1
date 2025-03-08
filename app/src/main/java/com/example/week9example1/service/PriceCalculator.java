package com.example.week9example1.service;

import com.example.week9example1.model.Product;

public class PriceCalculator {
    public double calculateTotalPrice(Product product, int quantity) {
        return product.getPrice() * quantity;
    }

    public double calculatePriceWithTax(Product product, double taxRate) {
        return product.getPrice() * (1 + taxRate);
    }
}

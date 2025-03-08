package com.example.week9example1.repository;

import android.content.Context;

import com.example.week9example1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class LocalProductRepository implements ProductRepository {
    private Context context;

    public LocalProductRepository(Context context) {
        this.context = context;
    }

    @Override
    public void saveProduct(Product product) {
        // Implementation to save product to local storage (Room, SharedPreferences, etc.)
        System.out.println("Saving product to local database: " + product.getName());
    }

    @Override
    public Product getProductById(String id) {
        // Implementation to get product from local storage
        System.out.println("Fetching product from local database with ID: " + id);
        return null; // Placeholder
    }

    @Override
    public List<Product> getAllProducts() {
        // Implementation to get all products from local storage
        System.out.println("Fetching all products from local database");
        return new ArrayList<>(); // Placeholder
    }
}

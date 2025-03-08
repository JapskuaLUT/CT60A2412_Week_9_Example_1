package com.example.week9example1.repository;

import com.example.week9example1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class RemoteProductRepository implements ProductRepository {
    // Would use Retrofit or similar for actual implementation

    @Override
    public void saveProduct(Product product) {
        // Implementation to save product to remote API
        System.out.println("Saving product to remote API: " + product.getName());
    }

    @Override
    public Product getProductById(String id) {
        // Implementation to get product from remote API
        System.out.println("Fetching product from remote API with ID: " + id);
        return null; // Placeholder
    }

    @Override
    public List<Product> getAllProducts() {
        // Implementation to get all products from remote API
        System.out.println("Fetching all products from remote API");
        return new ArrayList<>(); // Placeholder
    }
}

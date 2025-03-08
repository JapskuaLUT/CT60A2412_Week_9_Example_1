package com.example.week9example1.repository;

import com.example.week9example1.model.Product;

import java.util.List;

public interface ProductRepository {
    void saveProduct(Product product);
    Product getProductById(String id);
    List<Product> getAllProducts();
}

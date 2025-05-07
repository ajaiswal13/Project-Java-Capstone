package com.example.productservicecapstone.services;

import com.example.productservicecapstone.exceptions.ProductNotFoundException;
import com.example.productservicecapstone.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(String name, String description, double price,
                          String imageUrl, String category);
}

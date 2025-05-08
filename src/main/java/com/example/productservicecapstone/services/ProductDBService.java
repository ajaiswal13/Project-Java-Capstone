package com.example.productservicecapstone.services;

import com.example.productservicecapstone.exceptions.ProductNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.productservicecapstone.models.Product;
import java.util.List;

@Service("productDBService")

//@Primary - Alternative to using Qualifier in ProductController
public class ProductDBService implements ProductService
{

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageUrl, String category) {
        return null;
    }
}

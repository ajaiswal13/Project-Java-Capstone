package com.example.productservicecapstone.repositories;

import com.example.productservicecapstone.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product save(Product product);
}

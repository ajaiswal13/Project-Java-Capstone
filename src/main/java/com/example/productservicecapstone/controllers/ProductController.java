package com.example.productservicecapstone.controllers;

import com.example.productservicecapstone.dtos.CreateFakeStoreProductDto;
import com.example.productservicecapstone.dtos.ProductResponseDto;
import com.example.productservicecapstone.exceptions.ProductNotFoundException;
import com.example.productservicecapstone.models.Product;
import com.example.productservicecapstone.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(
            @PathVariable("id") long id) throws ProductNotFoundException {

        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        ResponseEntity<ProductResponseDto> responseEntity =
                new ResponseEntity<>(productResponseDto, HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts()
    {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product : products)
        {
            ProductResponseDto productResponseDto = ProductResponseDto.from(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody
                                                CreateFakeStoreProductDto createFakeStoreProductDto)
    {
        //We are not passing the CreateFakeStoreProductDto directly as the method argument because
        //then we will have to change the method signature of this method in ProductService interface also
        // and this is not how we generally code services
        Product product = productService.createProduct(
                createFakeStoreProductDto.getName(),
                createFakeStoreProductDto.getDescription(),
                createFakeStoreProductDto.getPrice(),
                createFakeStoreProductDto.getImageUrl(),
                createFakeStoreProductDto.getCategory()
        );

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);

        return productResponseDto;
    }

}

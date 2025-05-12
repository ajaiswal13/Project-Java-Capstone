package com.example.productservicecapstone.controllers;

import com.example.productservicecapstone.dtos.ProductResponseDto;
import com.example.productservicecapstone.exceptions.ProductNotFoundException;
import com.example.productservicecapstone.models.Category;
import com.example.productservicecapstone.models.Product;
import com.example.productservicecapstone.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @MockitoBean
    @Qualifier("productDBService") //If we don't use qualifier we get IllegalStateException: No qualifying bean of type 'com.example.productservicecapstone.services.ProductService' available
    //while running the test case as there are two ProductService implementations ProductDBService and FakeStoreProductService
    public ProductService productService;

    @Autowired
    public ProductController productController;

    @Test
    public void testGetProductByIdReturnsProductResponseDto() throws ProductNotFoundException {
        Product dummyProduct = new Product();
        dummyProduct.setId(1L);
        dummyProduct.setName("Dummy Product");
        dummyProduct.setDescription("Dummy Description");
        dummyProduct.setPrice(100.0);
        dummyProduct.setImageUrl("Dummy Image Url");

        Category dummyCategory = new Category();
        dummyCategory.setDescription("Dummy Category");
        dummyCategory.setName("Dummy Category Name");
        dummyCategory.setId(1L);

        dummyProduct.setCategory(dummyCategory);

        when(productService.getProductById(1L)).thenReturn(dummyProduct);

        ProductResponseDto productResponseDto = productController.getProductById(1L);

//        If response is in form of ResponseEntity
//        ResponseEntity<ProductResponseDto> productResponseDto = productController.getProductById(1L);
//        assertEquals(1L,productResponseDto.getBody().getId());

        assertEquals(1L,productResponseDto.getId());
        assertEquals("Dummy Product",productResponseDto.getName());
        //We can do it for all the other fields as well.
    }

    @Test
    public void testGetProductByIdReturnsNull() throws ProductNotFoundException {
        when(productService.getProductById(1L)).thenReturn(null);

        ProductResponseDto productResponseDto = productController.getProductById(1L);
        assertNull(productResponseDto);
    }
}
package com.example.productservicecapstone.services;

import com.example.productservicecapstone.dtos.FakeStoreProductDto;
import com.example.productservicecapstone.exceptions.ProductNotFoundException;
import com.example.productservicecapstone.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class FakeStoreProductServiceTest {

    @MockitoBean
    RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService fakeStoreProductService;

    @Test
    public void testGetProductByIdReturnsProduct() throws ProductNotFoundException {
        FakeStoreProductDto dummyResponse = new FakeStoreProductDto();
        dummyResponse.setId(1L);
        dummyResponse.setTitle("title");
        dummyResponse.setDescription("description");
        dummyResponse.setPrice(1.0);
        dummyResponse.setImage("img.url");
        dummyResponse.setCategory("category");

        when(restTemplate.getForObject(
                "https://fakestoreapi.com/products/1",
                FakeStoreProductDto.class)).thenReturn(dummyResponse);

        Product product = fakeStoreProductService.getProductById(1L);

        assertEquals(1L, product.getId());
        assertEquals("title", product.getName());
    }

    @Test
    public void testGetProductByIdWithNullProductThrowingException() throws ProductNotFoundException {
        when(restTemplate.getForObject(
                "https://fakestoreapi.com/products/1",
                FakeStoreProductDto.class)).thenReturn(null);

        assertThrows(ProductNotFoundException.class,() -> fakeStoreProductService.getProductById(1L));
    }

    @Test
    public void testCreateProductReturnsProductWithId()
    {
        FakeStoreProductDto dummyResponse = new FakeStoreProductDto();
        dummyResponse.setId(1L);
        dummyResponse.setTitle("title");
        dummyResponse.setDescription("description");
        dummyResponse.setPrice(1.0);
        dummyResponse.setImage("img.url");
        dummyResponse.setCategory("category");

        when(restTemplate.postForObject(
                eq("https://fakestoreapi.com/products"), //Since we are using any() below instead of actual object, we have to use eq here or error will come while running the test case
                any(), //Here any is used because whatever object we pass from here it will not match the fakeStoreProductRequestDto
                //of the original method signature as object references will be different and our test case will fail
                eq(FakeStoreProductDto.class))).thenReturn(dummyResponse); //Since we are using any() above instead of actual object, we have to use eq here

        Product product = fakeStoreProductService.createProduct("title", "description", 12.1,
                "img.url", "category");

        assertEquals(1L, product.getId());
        assertEquals("title", product.getName());
    }

    @Test
    public void testCreateProductVerifyAPICalls()
    {
        FakeStoreProductDto dummyResponse = new FakeStoreProductDto();
        dummyResponse.setId(1L);
        dummyResponse.setTitle("title");
        dummyResponse.setDescription("description");
        dummyResponse.setPrice(1.0);
        dummyResponse.setImage("img.url");
        dummyResponse.setCategory("category");

        when(restTemplate.postForObject(
                eq("https://fakestoreapi.com/products"), //Since we are using any() below instead of actual object, we have to use eq here or error will come while running the test case
                any(), //Here any is used because whatever object we pass from here it will not match the fakeStoreProductRequestDto
                //of the original method signature as object references will be different and our test case will fail
                eq(FakeStoreProductDto.class))).thenReturn(dummyResponse); //Since we are using any() above instead of actual object, we have to use eq here

        Product product = fakeStoreProductService.createProduct("title", "description", 12.1,
                "img.url", "category");

       verify(restTemplate,times(1)).postForObject(
            eq("https://fakestoreapi.com/products"),
            any(),
            eq(FakeStoreProductDto.class));
    }
}
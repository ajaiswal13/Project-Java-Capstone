package com.example.productservicecapstone.dtos;

import com.example.productservicecapstone.models.Category;
import com.example.productservicecapstone.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//The format of this class is as per the api response
public class FakeStoreProductDto {

    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct()
    {
        Product product = new Product();
        product.setId(id);
        product.setDescription(description);
        product.setName(title);
        product.setPrice(price);
        product.setImageUrl(image);

        Category category1 = new Category();
        category1.setName(category);

        product.setCategory(category1);
        return product;
    }
}

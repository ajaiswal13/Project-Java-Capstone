package com.example.productservicecapstone.services;

import com.example.productservicecapstone.exceptions.ProductNotFoundException;
import com.example.productservicecapstone.models.Category;
import com.example.productservicecapstone.repositories.CategoryRepository;
import com.example.productservicecapstone.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.productservicecapstone.models.Product;
import java.util.List;
import java.util.Optional;

@Service("productDBService")

//@Primary - Alternative to using Qualifier in ProductController
public class ProductDBService implements ProductService
{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public ProductDBService(ProductRepository productRepository,
                            CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty())
        {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String name, String description, double price,
                                 String imageUrl, String category)
    {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryObj = getCategoryFromDB(category);

        product.setCategory(categoryObj);
        return productRepository.save(product);
    }

    private Category getCategoryFromDB(String name)
    {
        Optional<Category> optionalCategory = categoryRepository.findByName(name);
        if(optionalCategory.isPresent())
        {
            return optionalCategory.get();
        }

        Category category = new Category();
        category.setName(name);

        return categoryRepository.save(category);
    }
}

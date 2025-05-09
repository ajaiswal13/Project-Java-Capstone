package com.example.productservicecapstone.repositories;

import com.example.productservicecapstone.models.Category;
import com.example.productservicecapstone.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(long id);

    List<Product> findByCategory(Category category);

    List<Product> findByCategory_Name(String categoryName); //Declarative query

    @Query("select p from Product p where p.category.name= :categoryName") //HQL query
    List<Product> getProductByCategoryName(@Param("categoryName") String categoryName);

    @Query(value = CustomQuery.GET_PRODUCTS_FROM_CATEGORY_NAME, nativeQuery = true) //Native SQL query
    List<Product> getProductsByCategoryNameNative(@Param("categoryName") String categoryName);

    //In both the queries above, we are using @Param for backward compatibility with Spring Data JPA 2.0.
    //After Spring Data JPA 2.0, @Param is not required.
}

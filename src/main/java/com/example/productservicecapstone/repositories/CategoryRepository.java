package com.example.productservicecapstone.repositories;

import com.example.productservicecapstone.models.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    @EntityGraph(attributePaths = "products") //This is used to enforce the FetchMode. Value("products") should be same as the name of the attribute in Category class.
    //Null can be returned here. So in order to avoid the null check in Service, we are using Optional
    Optional<Category> findByName(String name);

    Category save(Category category);
}
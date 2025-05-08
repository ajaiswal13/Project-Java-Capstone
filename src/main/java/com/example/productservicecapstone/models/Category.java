package com.example.productservicecapstone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String description;

    //Mapped by is used because in this class we have 2 list of products
    //To identify the mapping is with which list, mappedBy is used
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    //Below was just for example
    //@OneToMany
    //private List<Product> featuredProducts;
}

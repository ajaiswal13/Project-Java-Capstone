package com.example.productservicecapstone.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel
{
    @Id

    //If use strategy as GenerationType.AUTO, JPA will choose the strategy according to the type of database
    // For MySql database, there are 2 strategies - SEQUENCE, IDENTITY. JPA can choose either of them.
    // In SEQUENCE strategy sequence tables will be created for all the models to keep track of the next id
    // we changed the strategy so that we can control it by ourselves
    //For Oracle, it is TABLE (need to check,not sure)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date createdAt;
    private Date lastModified;
    private boolean isDeleted;
}
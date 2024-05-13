package com.example.democlient.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;



@Data
public class MyEntity {

    private int id;

    private String title;
    

    private String description;


    private int price;

    private float discountPercentage;

    private float rating;

    private int stock;


    private String brand;
    private String category;
    private String thumbnail;

    @OneToMany
    private List<String> images;


    
}

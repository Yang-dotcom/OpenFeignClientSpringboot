package com.example.democlient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

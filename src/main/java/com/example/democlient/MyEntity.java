package com.example.democlient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;
    @Column(name = "discountPercentage")
    private int discountPercentage;
    @Column(name = "rating")
    private int rating;
    @Column(name = "stock")
    private int stock;

    @Column(name = "brand")
    private String brand;
    @Column(name = "category")
    private String category;

    //TODO images field

    
}

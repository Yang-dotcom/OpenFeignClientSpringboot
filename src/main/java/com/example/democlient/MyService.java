package com.example.democlient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@ComponentScan(basePackageClasses=ProductRepository.class)
public class MyService {

    private final ProductRepository productRepository;

    @Autowired
    public MyService(MyFeignClient myFeignClient, ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * prints the result of the GET request
     */
    public String getAllProducts() {
       return productRepository.getAllProducts();
    }

    public String getProductById(int id) {
        return productRepository.getProductById(    id);
    }

}

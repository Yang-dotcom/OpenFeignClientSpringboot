package com.example.democlient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private final MyFeignClient myFeignClient;

    public ProductRepository(MyFeignClient myFeignClient) {
        this.myFeignClient = myFeignClient;
    }

    public String getAllProducts(){
        return myFeignClient.getAllProducts();
    }
}

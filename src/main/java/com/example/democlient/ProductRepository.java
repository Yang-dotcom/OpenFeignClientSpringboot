package com.example.democlient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

/**
 * The repository is the persistent (data acquisition layer) of the
 * Springboot webClient model
 */
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

    public String getProductById(int id){
        return myFeignClient.getProductById(id);
    }


}

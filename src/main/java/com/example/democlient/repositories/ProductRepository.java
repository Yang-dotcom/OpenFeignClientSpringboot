package com.example.democlient.repositories;

import com.example.democlient.client.MyFeignClient;
import com.example.democlient.models.MultipleProducts;
import com.example.democlient.models.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public MultipleProducts getAllProducts(){
        return myFeignClient.getAllProducts();
    }

    public MyEntity getProductById(int id){
        return myFeignClient.getProductById(id);
    }

    public List<MyEntity> searchProduct(String keyword){
        return myFeignClient.searchProducts(keyword);
    }


}

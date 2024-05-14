package com.example.democlient.repositories;

import com.example.democlient.client.MyFeignClient;
import com.example.democlient.models.MultipleProducts;
import com.example.democlient.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
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

    public MultipleProducts getAllProducts(){
        return myFeignClient.getAllProducts();
    }

    public Product getProductById(int id){
        return myFeignClient.getProductById(id);
    }

    public MultipleProducts searchProduct(String keyword){
        return myFeignClient.searchProducts(keyword);
    }

    public String[] getCategories(){
        return myFeignClient.getCategories();
    }


}

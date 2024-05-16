package com.example.democlient.infrastructure.repositories;

import com.example.democlient.domain.services.models.MultipleProducts;
import com.example.democlient.domain.services.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * The repository is the persistent (data acquisition layer) of the
 * Springboot webClient model. (NOTE: I have a suspicion that it's not needed,
 * as the openFeignClient already acts as an interface to the API to make requests)
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

    public Map<String, Object> getLimitSkipProducts(Integer limit, Integer skip, String select){
        return myFeignClient.getLimitSkipProducts(limit, skip, select);
    }

    public MultipleProducts getProductsCategory(String str){
        return myFeignClient.getProductsCategory(str);
    }

    public Product createProduct(Product product){return myFeignClient.addProduct(product);}

    public Map<String, Object> updateProduct(int id, Map<String, Object> product){return myFeignClient.updateProduct(id, product);}


}

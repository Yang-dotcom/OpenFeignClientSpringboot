package com.example.democlient.services;

import com.example.democlient.models.MultipleProducts;
import com.example.democlient.models.MyEntity;
import com.example.democlient.client.MyFeignClient;
import com.example.democlient.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@Service
@ComponentScan(basePackageClasses= ProductRepository.class)
public class MyService {

    private final ProductRepository productRepository;

    @Autowired
    public MyService(MyFeignClient myFeignClient, ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * prints the result of the GET request
     */
    public MultipleProducts getAllProducts() {
       return productRepository.getAllProducts();
    }

    public MyEntity getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public MyEntity[] searchProducts(String keyword){
        MyEntity[] filteredProducts = productRepository.searchProduct(keyword)
                                    .stream().filter(product -> product.getCategory()
                                    .toLowerCase().contains(keyword.toLowerCase()))
                                    .toArray(MyEntity[]::new);

        return filteredProducts;
    }

}

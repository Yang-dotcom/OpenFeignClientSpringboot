package com.example.democlient.controllers;

import com.example.democlient.models.MultipleProducts;
import com.example.democlient.models.MyEntity;
import com.example.democlient.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products result")
public class Controller {

    @Autowired
    private final MyService myService;
    @Autowired
    public Controller(MyService myService) {
        this.myService = myService;
    }

    /**
     * the path provided as parameter in @GetMapping having
     * root the local port 8080
     * is the location where the result of the method getAllProducts
     * is stored
     */
    @GetMapping()
    public MultipleProducts getAllProducts() {
       return myService.getAllProducts();
    }

    @GetMapping("/{productID}")
    public MyEntity getProductId(@PathVariable("productID") int productID) {
        return myService.getProductById(productID);
    }

    @GetMapping(value = "/search")public MyEntity[] searchProducts(@RequestParam String keyword){
        return myService.searchProducts(keyword);
    }
}

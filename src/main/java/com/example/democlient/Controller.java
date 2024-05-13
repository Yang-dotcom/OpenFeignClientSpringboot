package com.example.democlient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
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
    @GetMapping("/products result")
    public String getAllProducts() {
       return myService.getAllProducts();
    }

    @GetMapping("/products result/{productID}")
    public String getProductId(@PathVariable("productID") int productID) {
        return myService.getProductById(productID);
    }
}

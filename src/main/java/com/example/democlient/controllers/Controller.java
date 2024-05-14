package com.example.democlient.controllers;

import com.example.democlient.models.MultipleProducts;
import com.example.democlient.models.Product;
import com.example.democlient.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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


    public MultipleProducts getAllProducts() {
       return (MultipleProducts) myService.getLimitSkipProducts(0,0,"");
    }

    @GetMapping("/{productID}")
    public Product getProductId(@PathVariable("productID") int productID) {
        return myService.getProductById(productID);
    }

    @GetMapping(value = "/search")
    public MultipleProducts searchProducts(@RequestParam String keyword){
        return myService.searchProducts(keyword);
    }

    @GetMapping(value = "/categories")
    public String[] getCategories(){
        return myService.getCategories();
    }

    @GetMapping()
    public Map<String, Object> getLimitSkipProducts(@RequestParam(value = "limit", required = false, defaultValue = "0") Integer limit,
                                                    @RequestParam(value = "skip", required = false, defaultValue = "0") Integer skip,
                                                    @RequestParam(value = "select",required = false, defaultValue = "") String select){
        return myService.getLimitSkipProducts(limit, skip, select);
    }
    @GetMapping("/category/{nameCategory}")
    public MultipleProducts getProductsCategory(@PathVariable(name = "nameCategory") String str){
        return myService.getProductsCategory(str);
    }
}

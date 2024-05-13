package com.example.democlient;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

import java.util.List;

@FeignClient(name = "myFeignClient", url = "https://dummyjson.com/products")
/**
 * @RequestMapping annotation at the class level to define a base path for all the methods within the controller.
 * Then, you can use relative paths in the @GetMapping annotations of individual methods
 * This approach helps in reducing code duplication and makes the code more readable and maintainable.
 */
public interface MyFeignClient {

    /**
     *  The root is the url provided to the @FeignClient(), the path
     *  in the @GetMapping is the path on which the GET request is performed
     * @return String (Other return options are Mono, Flux, ResponseEntity, or other Java objects)
     */
    @GetMapping()
     MultipleProducts getAllProducts();

    @GetMapping("/{productID}")
    MyEntity getProductById(@PathVariable("productID") int productID);

    @GetMapping(value = "/search")
    List<MyEntity> searchProducts(@RequestParam String searchKey);



}

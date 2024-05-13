package com.example.democlient;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@FeignClient(name = "myFeignClient", url = "https://dummyjson.com")
public interface MyFeignClient {

    /**
     *  The root is the url provided to the @FeignClient(), the path
     *  in the @GetMapping is the path on which the GET request is performed
     * @return String (Other return options are Mono, Flux, ResponseEntity, or other Java objects)
     */
    @GetMapping("/products")
    String getAllProducts();

    @GetMapping("/products/{productID}")
    String getProductById(@PathVariable("productID") int productID);
}

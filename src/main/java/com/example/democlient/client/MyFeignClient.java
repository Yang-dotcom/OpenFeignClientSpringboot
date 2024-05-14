package com.example.democlient.client;
import com.example.democlient.models.MultipleProducts;
import com.example.democlient.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
    Product getProductById(@PathVariable("productID") int productID);


    /**
     * VERY IMPORTANT: the name of the parameter has to be the same
     * as the one used by the API when the client is requesting directly
     * @param q name of the string to be searched for. the name of this variable
     *          must be the same as the name of the variable used by the API
     * @return {@code MultipleProducts} list of products containing the word {@code String q}
     */
    @GetMapping(value = "/search")
    MultipleProducts searchProducts(@RequestParam String q);

    @GetMapping(value = "/categories")
    String[] getCategories();



}

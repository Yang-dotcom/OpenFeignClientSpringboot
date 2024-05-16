package com.example.democlient.infrastructure.repositories;
import com.example.democlient.domain.services.models.MultipleProducts;
import com.example.democlient.domain.services.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@FeignClient(name = "myFeignClient", url = "https://dummyjson.com/products", configuration = FeignConfig.class)
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
     * as the one used by the API when the client is requesting directly unless I map
     * the url name variable to the java name variable like so:
     * {@code @RequestParam(name="q") String searchkey}
     * @param q name of the string to be searched for. the name of this variable
     *          must be the same as the name of the variable used by the API
     * @return {@code MultipleProducts} list of products containing the word {@code String q}
     */
    @GetMapping(value = "/search")
    MultipleProducts searchProducts(@RequestParam String q);

    @GetMapping(value = "/categories")
    String[] getCategories();


    /**
     * VERY IMPORTANT: initially, the return type of getProducts() was ProductResponse.
     * This means Feign expected the JSON response to match the structure of the ProductResponse class exactly.
     * If there is any mismatch in the structure, missing fields, or if the API response includes dynamic fields that
     * ProductResponse doesn't account for, Feign will fail to deserialize the response properly,
     * leading to the DecodeException.
     * <p>
     *     By changing the return type to Map<String, Object>, you are essentially telling
     *     Feign to deserialize the JSON response into a generic map where keys are strings (representing the JSON keys) and
     *     values are objects (representing the JSON values). This approach is more flexible and can handle dynamic or unexpected
     *     fields in the JSON response without failing.
     * </p>By changing the return type to Map<String, Object>, you are essentially telling
     * @param limit indicates how many entries to get
     * @param skip  indicates how many entries have to be skipped
     * @param select indicates the selected fields of {@code Product}
     * @return {@code Map<String, Object>} where String is a JSON key and Object is a JSON value
     */
    @GetMapping()
    Map<String, Object> getLimitSkipProducts( @RequestParam("limit") Integer limit,
                                           @RequestParam("skip") Integer skip,
                                           @RequestParam("select") String select);

    @GetMapping("/category/{categoryName}")
    MultipleProducts getProductsCategory(@PathVariable(name = "categoryName") String categoryName);

    @PostMapping("/add")
    Product addProduct(@RequestBody Product product);





}

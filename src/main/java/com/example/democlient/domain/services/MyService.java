package com.example.democlient.domain.services;

import com.example.democlient.domain.services.models.MultipleProducts;
import com.example.democlient.domain.services.models.Product;
import com.example.democlient.infrastructure.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  Service class that handles the business logic of a springboot application
 * @author dingyang.chen
 * @version 1.0
 * @since 2024-05-08
 */
@Slf4j
@Service
@ComponentScan(basePackageClasses= ProductRepository.class)
public class MyService {
    /**
     *  Dependency Injection of Interface {@code ProductRepository} that interacts
     *  directly with the Database/API through {@code MyFeignClient}
     *  <p>
     *      Inversion of Control is implemented through the Dependency Injection:
     *      the field {@code private final ProductRepository} is not managed (e.g. its creation)
     *      by program directly, but instead an external entity controls it (Springboot framework).
     * <p>
     *      this allows decoupling, allowing more modularity, testability and maintainable code.
     * <p>
     *  </p>
     */
    private final ProductRepository productRepository;

    @Autowired
    public MyService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public MultipleProducts getAllProducts() {
       return productRepository.getAllProducts();
    }

    /**
     *
     * @param id of a single product we're looking for
     * @return the single product
     */

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }


    /**Filters the response form a GET request to get only
     * those that contain the inputted keyword.
     * NB: the commented lines are not useful since the processing is handled
     * by the API
     *
     * <p>
     *     The commented code is left in case it may be needed for the client
     *     to process the incoming data (e.g. use of filters)
     * </p>
     *
     * @param keyword {@code String } to be searched for
     * @return the filtered response {@code MultipleProducts}
     */
    public MultipleProducts searchProducts(String keyword){
//        List<Product> filteredProducts = productRepository.getAllProducts().getProducts()
//                                    .stream().filter(product -> product.getCategory()
//                                    .toLowerCase().contains("phone".toLowerCase()))
//                                    .collect(Collectors.toList());
//       List<Product> filteredProducts = productRepository.searchProduct(keyword).getProducts();
       // filteredProducts.forEach(x -> log.info(x.getTitle()));
//        log.info("Hello");
//        for (Product pr: filteredProducts){
//            System.out.println(pr.getTitle() + "                empty");
//        }

//        return MultipleProducts.builder()
//                                    .products(filteredProducts)
//                                    .total(filteredProducts.size())
//                                    .skip(0).limit(0).build();

        return productRepository.searchProduct(keyword);
    }

    public String[] getCategories(){
        return productRepository.getCategories();
    }

    public Map<String, Object> getLimitSkipProducts(Integer limit, Integer skip, String select){
        return productRepository.getLimitSkipProducts(limit, skip, select);
    }

    public MultipleProducts getProductsCategory(String str){
        return productRepository.getProductsCategory(str);
    }

    public Product createProduct(Product product){
        try {
            Product response = productRepository.createProduct(product);
            log.info("Successfully created product: {}", response);
            return response;
        } catch (Exception e) {
            log.error("Failed to create product", e);
            throw e;  // rethrow the exception after logging it
        }
    }

    public Map<String, Object> updateProduct(int id, Map<String, Object> product){
        try {
            Map<String, Object> response = productRepository.updateProduct(id, product);
            log.info("Successfully updated product: {}", response);
            return response;
        } catch (Exception e) {
            log.error("Failed to update product", e);
            throw e;  // rethrow the exception after logging it
        }
    }
    public Map<String, Object> deleteProduct(int id){
        try {
            Map<String, Object> response = productRepository.deleteProduct(id);
            log.info("Successfully deleted product: {}", response);
            return response;
        } catch (Exception e) {
            log.error("Failed to delete product", e);
            throw e;  // rethrow the exception after logging it
        }
    }

}

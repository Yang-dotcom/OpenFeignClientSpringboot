package com.example.democlient;

import com.example.democlient.services.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemoClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoClientApplication.class, args);
        MyService exampleService = context.getBean(MyService.class);
        exampleService.getAllProducts();
        exampleService.getProductById(1);
       // exampleService.searchProducts("phone");
    }

    /**
     *  How this webclient works using OpenFeignClient GET operations.
     *
     *  1) main() is executed running SpringApplication
     *  2) SpringApplication initializes the methods in the Controller module
     *  3) Controller module calls on the Service, which implements the business logic
     *      (how data should be processed) by use of a Repository module, which
     *      is responsible for data storage and retrieval (and it does so using OpenFeignClient)
     *  4) in the main, by creating an app context bound to SpringApplication, I create an instance of the service
     *      by getting the bean from the created context, then run it. Doing so, when I run the application,
     *      it will also call the service methods I want to call
     *
     *   5) A better way to write this webClient would be to create tests in the test folder and simply run
     *      that folder form main (that is, not putting testing method calls in the main class)
     *
     */

}

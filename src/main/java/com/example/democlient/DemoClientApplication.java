package com.example.democlient;

import com.example.democlient.domain.services.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);


    }

    /**
     *  How this webclient works using OpenFeignClient GET operations.
     *
     *  1) main() is executed running SpringApplication
     *  2) SpringApplication initializes the methods in the Controller module
     *  3) Controller module calls on the Service, which implements the business logic
     *      (how data should be processed) by use of a Repository module, which
     *      is responsible for data storage and retrieval (and it does so using OpenFeignClient)
     */

}

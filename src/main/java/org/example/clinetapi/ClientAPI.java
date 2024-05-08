package org.example.clinetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@RestController
@SpringBootApplication
public class ClientAPI {
    public static void main(String[] args) {
        SpringApplication.run(ClientAPI.class, args);
    }

//    @GetMapping("/hello")
//    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
//        return String.format("Hello %s!", name);
//        GIT test
//}


}

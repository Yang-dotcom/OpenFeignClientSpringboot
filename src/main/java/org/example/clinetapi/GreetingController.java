package org.example.clinetapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s";
    // AtomicLong is like long but can be used in concurrent environment, also doesn't need wrapper class
    private final AtomicLong counter = new AtomicLong();

    // getMapping ensures hhtp requests to /greeting are handled by the method greeting
    // @RequestParam takes the read qury String name and binds it to value = "name" of greeting()
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // method body returns object Greeting with id = incremented counter, content = formatted template
        // This is how a RESTful controller handles it (populate an object whose data will be written into HTTP response as JSON)
        // traditional MVC controller relies on a view technology to render greeting data to HTML (the programming language)
        // the Greeting object should be converted to JSON but we don't need to do this manually hanks to Spring HTTP message converter
        return new Greeting(counter.incrementAndGet(), String.format(template, name));


    }

}
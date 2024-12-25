package com.vaibhav.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")  
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello, World!");
    }

    @GetMapping(value = "/hello-world/path-var/{name}")
    public HelloWorldBean helloWorldBeanPathVar(@PathVariable String name) {
        return new HelloWorldBean("Hello, " + name);
    }
}

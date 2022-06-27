package com.example.demo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

@Controller("/")
public class GreetingController {
    @Get(uri = "/greeting")
    public Greeting greeting(@QueryValue(value = "name", defaultValue = "World") String name) {
        return new Greeting("Hello, " + name + "!");
    }
}

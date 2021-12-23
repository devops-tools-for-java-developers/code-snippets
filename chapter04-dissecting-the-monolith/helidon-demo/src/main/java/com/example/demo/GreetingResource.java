package com.example.demo;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/greeting")
public class GreetingResource {
    private static final String template = "Hello, %s!";

    @GET
    public Greeting greeting(@QueryParam("name") @DefaultValue("World") String name) {
        return new Greeting(String.format(template, name));
    }
}

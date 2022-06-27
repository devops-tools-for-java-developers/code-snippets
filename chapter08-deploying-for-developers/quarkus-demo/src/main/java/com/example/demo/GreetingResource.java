package com.example.demo;


import io.micrometer.core.annotation.Timed;
import io.opentelemetry.api.trace.*;
import io.opentelemetry.context.Context;

import javax.ws.rs.*;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {
    private static final String template = "Hello, %s!";

    private final static Logger log;

    static {
        log = Logger.getLogger(GreetingResource.class.getName());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed(value="custom")
    public Greeting greeting(@QueryParam("name") String name) {
        pause();
        return new Greeting(String.format(template, name));
    }

    private void pause() {
        Span span = Span.fromContext(Context.current())
                .setAttribute("pause", "start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            span.setStatus(StatusCode.ERROR, "Execution was interrupted");
            span.setAttribute("unexpected.pause", "exception");
            span.recordException(e);
            log.severe("Thread interrupted");
        }
    }
}
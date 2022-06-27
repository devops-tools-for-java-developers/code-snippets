package com.example.demo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessingService {
    public OutputObject process(InputObject input) {
        OutputObject output = new OutputObject();
        output.setResult(input.getGreeting() + " " + input.getName());
        return output;
    }
}

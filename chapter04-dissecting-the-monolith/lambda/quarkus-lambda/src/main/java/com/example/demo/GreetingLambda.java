package com.example.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import javax.inject.Named;

@Named("greeting")
public class GreetingLambda implements RequestHandler<InputObject, OutputObject> {
    @Inject
    ProcessingService service;

    @Override
    public OutputObject handleRequest(InputObject input, Context context) {
        OutputObject output = service.process(input);
        output.setRequestId(context.getAwsRequestId());
        return output;
    }
}

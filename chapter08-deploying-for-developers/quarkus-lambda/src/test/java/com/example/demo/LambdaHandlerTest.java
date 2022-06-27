package com.example.demo;

import io.quarkus.amazon.lambda.test.LambdaClient;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class LambdaHandlerTest {
    @Test
    public void testSimpleLambdaSuccess() throws Exception {
        InputObject in = new InputObject();
        in.setGreeting("Hello");
        in.setName("serverless");
        OutputObject out = LambdaClient.invoke(OutputObject.class, in);
        Assertions.assertEquals("Hello serverless", out.getResult());
        Assertions.assertTrue(out.getRequestId().matches("aws-request-\\d"), "Expected requestId as 'aws-request-<number>'");
    }
}

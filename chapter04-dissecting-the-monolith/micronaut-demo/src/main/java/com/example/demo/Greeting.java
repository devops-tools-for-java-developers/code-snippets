package com.example.demo;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Greeting {
    private final String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

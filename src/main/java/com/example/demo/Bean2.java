package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class Bean2 implements IMyBean{
    @Override
    public void printMessage() {
        System.out.println("BEAN-2");
    }

    @Override
    public String getMessage() {
        return "BEAN-2";
    }
}
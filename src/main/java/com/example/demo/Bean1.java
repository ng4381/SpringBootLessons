package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class Bean1 implements IMyBean{
    @Override
    public void printMessage() {
        System.out.println("BEAN-1");
    }

    @Override
    public String getMessage() {
        return "BEAN-1";
    }
}

package com.nelkinda.training.java.modules.hello.greeting;

public class Greeter {
    private final String greeting;
    public Greeter(final String greeting) {
        this.greeting = greeting;
    }
    public String greet(final String whom) {
        return greeting + ", " + whom + "!";
    }
}

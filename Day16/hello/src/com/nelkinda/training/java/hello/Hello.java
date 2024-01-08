package com.nelkinda.training.java.hello;

import com.nelkinda.training.java.hello.greeting.Greeter;

public class Hello {
    public static void main(final String... args) {
        System.out.println(new Greeter("Hello").greet("world"));
    }
}

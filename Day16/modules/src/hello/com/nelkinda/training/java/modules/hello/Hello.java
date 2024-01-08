package com.nelkinda.training.java.modules.hello;

import com.nelkinda.training.java.modules.hello.greeting.Greeter;

public class Hello {
    public static void hello() {
        System.out.println(new Greeter("Hello").greet("world"));
    }
}

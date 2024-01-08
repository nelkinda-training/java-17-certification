package com.nelkinda.training.java.hello.greeting;

//                       Same class  | Class within same package | Subclass | World
// private                   Yes     |             No            |    No    |   No
// (package-default)         Yes     |             Yes           |    No    |   No
// protected                 Yes     |             Yes           |    Yes   |   No
// public                    Yes     |             Yes           |    Yes   |   Yes

public class Greeter {
    private final String greeting;
    public Greeter(final String greeting) {
        this.greeting = greeting;
    }

    public String greet(final String whom) {
        return greeting + ", " + whom + "!";
    }
}

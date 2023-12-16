class Super {
    public void method() {
        System.out.println("method from Super");
    }
    public static void staticMethod() {
        System.out.println("static method from Super");
    }
}

class Sub extends Super {
    @Override
    public void method() {
        System.out.println("method from Sub");
    }

    public static void staticMethod() {
        System.out.println("static method from Sub");
    }
}

class Main {
    public static void main(final String... args) {
        Super s = new Sub(); // Compile-time type: Super; Runtime-type: Sub
        s.method(); // method from Sub (all instance-methods in Java are virtual)
                    // Therefore prints "method from Sub"
        s.staticMethod(); // staticMethod() is static and thus resolved via the class/compile-time type.
                          // Therefore prints "static method from Super"
                          // Don't do this: Don't reference static methods via instances!
        Super.staticMethod(); // Instead, always call static methods through the class, not an instance.
        callMethodFrom(s);
    }
    public static void callMethodFrom(final Super s) {
        s.method(); // Prints "method from Sub"
        s.staticMethod(); // staticMethod() is static and thus resolved via the class/compile-time type.
                          // Therefore prints "static method from Super"
                          // Don't do this: Don't reference static methods via instances!
        Super.staticMethod();
    }
}

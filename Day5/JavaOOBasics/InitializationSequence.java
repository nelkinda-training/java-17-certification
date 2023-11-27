class Super {
    {
        System.out.println("Instance initializer of Super");
    }

    Super() {
        System.out.println("Constructor of Super");
    }
}

class Sub extends Super {
    {
        System.out.println("Instance initializer of Sub");
    }

    Sub() {
        // 1. super() unless java.lang.Object or unless explicit this() call
        // 2. instance initializers unless explicit this() call
        // 3. Remaining code of this constructor
        System.out.println("Constructor of Sub");
    }
}

class Main {
    public static void main(final String... args) {
        new Sub();
    }
}

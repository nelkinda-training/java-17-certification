class Super {
    Super() {
        System.out.println("Constructor of Super"); // 2.
    }

    {
        System.out.println("Instance initializer of Super"); // 1.
    }
}

class Sub extends Super {
    Sub() {
        // 1. super() unless java.lang.Object or unless explicit this() call
        // 2. instance initializers unless explicit this() call
        // 3. Remaining code of this constructor
        System.out.println("Constructor of Sub"); // 4.
    }

    {
        System.out.println("Instance initializer of Sub"); // 3.
    }

}

class Main {
    public static void main(final String... args) {
        new Sub();
    }
}

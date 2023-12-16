import java.util.function.*;

public class Namespaces {
    private static final int foo = 42; // field
    private static int foo() { // method
        return 42;
    }
    public static void main(final String... args) {
        System.out.println(foo);   // field foo
        System.out.println(foo()); // method foo by calling it
        System.out.println(Namespaces.foo);   // field foo
        System.out.println(Namespaces.foo()); // method foo by calling it
        System.out.println((IntSupplier) Namespaces::foo); // method foo by referring to it
    }
}

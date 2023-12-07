import java.util.function.*;

public class Namespaces {
    private final int foo = 42; // field

    private int foo() { // method
        return 42;
    }

    public static void main(final String... args) {
        final Namespaces ns = new Namespaces();
        ns.run();
        System.out.println(ns.foo);   // field foo
        System.out.println(ns.foo()); // method foo by calling it
        System.out.println((IntSupplier) ns::foo); // method foo by referring to it
    }

    public void run() {
        System.out.println(foo);   // field foo
        System.out.println(foo()); // method foo by calling it
        System.out.println(this.foo);   // field foo
        System.out.println(this.foo()); // method foo by calling it
        System.out.println((IntSupplier) this::foo); // method foo by referring to it
    }
}

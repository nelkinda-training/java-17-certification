import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

class Hello {
    public static int sum(final int a, final int b) {
        return a + b;
    }

    public static void main(final String... args) {
        System.out.println("Hello, World!");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Test {
}

class HelloTest {
    public static void main(final String... args) throws IllegalAccessException, InvocationTargetException {
        Arrays
            .stream(HelloTest.class.getMethods())
            .filter(method -> method.isAnnotationPresent(Test.class))
            .forEach(method -> { try {
                method.invoke(null);
            } catch (Exception e) { throw new RuntimeException(e); } });
    }

    @Test
    public static void testSum() {
        assertEquals(3, Hello.sum(1, 2));
    }

    @Test
    public static void testHelloPrintsHelloWorldOnStdout() {
        assertStdout("Hello, world!\n", () -> Hello.main());
    }

    public static void assertStdout(final String expected, final Runnable runnable) {
        final PrintStream originalStdout = System.out;
        try {
            final var capturedStdout = (OutputStream) new ByteArrayOutputStream(); // var is of type OutputStream
            System.setOut(new PrintStream(capturedStdout));
            runnable.run();
            assertEquals(expected, capturedStdout.toString());
        } finally {
            System.setOut(originalStdout);
        }
    }

    public static void assertEquals(final Object expected, final Object actual) {
        if (!Objects.equals(expected, actual))
            throw new AssertionError(String.format("Expected: <%s> but got: <%s>", expected, actual));
    }
}

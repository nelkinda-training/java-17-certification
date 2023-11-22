import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

class Hello {
    public static void main(final String... args) {
        System.out.println(getMessage());
    }

    public static String getMessage() {
        return "Hello, World!";
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
    public static void testHelloPrintsHelloWorldOnStdout() {
        assertEquals("Hello, world!", getMessage());
    }

    public static void assertEquals(final Object expected, final Object actual) {
        if (!Objects.equals(expected, actual))
            throw new AssertionError(String.format("Expected: <%s> but got: <%s>", expected, actual));
    }
}

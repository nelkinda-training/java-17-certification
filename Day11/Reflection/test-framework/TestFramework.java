import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Q1: What if the methods or members are private?
// Q2: What about inner classes?

class TestFramework {
    public static final int EXIT_FAILURE = 1;

    private int errors = 0;
    private int failures = 0;
    private int testcases = 0;

    public void executeTestCase(final Method testCase, final Object... parameters) {
        testcases++;
        try {
            Object testObject = testCase.getDeclaringClass().getDeclaredConstructor().newInstance();
            testCase.invoke(testObject, parameters);
        } catch (final IllegalAccessException | NoSuchMethodException e) {
            throw new AssertionError(e);
        } catch (final InvocationTargetException | InstantiationException e) {
            try {
                throw e.getCause();
            } catch (final AssertionError e2) {
                System.err.println(e2);
                failures++;
            } catch (final Throwable e2) {
                System.err.println(e2);
                errors++;
            }
        }
    }

    public static void main(final String... args) {
        new TestFramework().run(args);
    }

    public void run(final String... args) {
        Stream
            .of(args) // Stream<String>
            .map(this::forName) // Stream<Class<?>>
            .filter(testClass -> testClass != null) // Stream<Class<?>>
            //.map(Class::getMethods) // Stream<Method[]>
            //.map(Stream::of) // Stream<Stream<Method>>>
            //.flatMap(Function.identity()) // Stream<Method>
            .flatMap(testClass -> Stream.of(testClass.getMethods())) // Stream<Method>
            .filter(this::isTestCase) // Stream<Method>
            .flatMap(this::expandParameters) // Stream<Method>
            .forEach(Runnable::run); // void
        printStatistics();
        exit();
    }

    public Stream<Runnable> expandParameters(final Method testMethod) {
        // POI
        if (!testMethod.isAnnotationPresent(ParameterizedTest.class)) return Stream.of(() -> executeTestCase(testMethod));
        Values v1 = getValues(testMethod, 0);
        Values v2 = getValues(testMethod, 1);
        // POI
        return IntStream.range(0, v1.value().length).mapToObj(index -> () -> executeTestCase(testMethod, v1.value()[index], v2.value()[index]));
    }

    public Values getValues(final Method testMethod, final int index) {
        return Stream.of(testMethod.getParameterAnnotations()[index])
            .filter(annotation -> annotation instanceof Values)
            .map(it -> (Values) it)
            .findFirst()
            .get();
    }

    public Class<?> forName(final String testClassName) {
        try {
            return Class.forName(testClassName);
        } catch (final ClassNotFoundException e) {
            System.err.println(e);
            errors++;
            return null;
        }
    }

    /**
     * Returns whether the supplied method is a test case method.
     * @param testCase Method for which to check whether it is a test case method.
     * @return {@code true} if {@code testCase} is a test method, otherwise {@code false}.
     */
    public boolean isTestCase(final Method testCase) {
        return testCase.isAnnotationPresent(Test.class) || testCase.isAnnotationPresent(ParameterizedTest.class);
        //return testCase.getName().startsWith("test");
    }

    public void printStatistics() {
        System.out.format("""
            Test cases run: %d
            Test cases failed: %d
            Test errors: %d
            """, testcases, failures, errors);
    }

    public void exit() {
        if (errors > 0) System.exit(EXIT_FAILURE);
    }
}

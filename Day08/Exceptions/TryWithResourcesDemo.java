public class TryWithResourcesDemo {
    public static void main(final String... args) {
        try {
            runTryWithResources();
        } catch (final Throwable t) {
            System.err.println(t);
            t.printStackTrace();
        }
    }

    public static void runTryWithResources() throws Exception {
        // Note: close() calls are made in reserve order of allocation.
        try (
            // Scenario 1: Exception while allocating resources
            // In that case, that exception will be delivered.
            // All resources allocated prior will be released (close()).
            // All exceptions during release (close()) will be suppressed, that is
            // added as suppressed exceptions to the main exception (the exception from the failed resource allocation).
            final AutoCloseable a1 = openFirstAutoCloseable();
            final AutoCloseable a2 = openSecondAutoCloseable()
        ) {
            // Scenario 2: Exception during attempt
            // All resources could be allocated successfully, but the try {} block throws an exception.
            // The exception from the try {} block will be delivered.
            // All resources will be released (close()).
            // All exceptions during release (close()) will be suppressed, that is
            // added as suppressed exceptions to the main exception (the exception from the failed try {} block).
            doSomethingWith(a1, a2);
        }
        // Scenario 3: Exception during close
        // All resources could be allocated successfully, and the try {} block completed successfully.
        // But one of the close() calls throws an exception.
        // The first exception of all close() calls will be delivered.
        // All remaining close() calls will still be executed.
        // Any further exceptions from close() calls will be suppressed, that is
        // added as suppressed exceptions to the main exception (the exception from the first failing close() call).
    }

    public static void doSomethingWith(final AutoCloseable a1, final AutoCloseable a2) {
        System.err.println("doSomethingWith");
        //throw new RuntimeException("Exception in doSomethingWith()");
    }

    public static AutoCloseable openFirstAutoCloseable() {
        System.err.println("openFirstAutoCloseable()");
        // throw new RuntimeException("Exception in openFirstAutoCloseable()");
        return new AutoCloseable() {
            public void close() {
                System.err.println("close() of first AutoCloseable");
                //throw new RuntimeException("Exception in close() of first AutoCloseable");
            }
        };
    }

    public static AutoCloseable openSecondAutoCloseable() {
        System.err.println("openSecondAutoCloseable()");
        // throw new RuntimeException("Exception in openSecondAutoCloseable()");
        return new AutoCloseable() {
            public void close() {
                System.err.println("close() of second AutoCloseable");
                throw new RuntimeException("Exception in close() of second AutoCloseable");
            }
        };
        //return null;
    }
}

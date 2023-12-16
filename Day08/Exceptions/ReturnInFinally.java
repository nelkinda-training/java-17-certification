public class ReturnInFinally {
    public static void main(final String... args) {
        someFunction();
        someOtherFunction();
    }

    public static void someFunction() {
        try {
            throw new RuntimeException();
        } finally {
            // Putting a return inside a finally block will swallow all exceptions.
            return; // Return _explicitly_ returns to the caller in _normal_ (non-exception) flow.
        }
    }

    public static void someOtherFunction() {
        try {
            throwRuntimeException();
            return;
        } finally {
        }
    }

    public static void throwRuntimeException() {
        throw new RuntimeException();
    }
}

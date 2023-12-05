public class ThrowExceptionInStaticInitializer {
    static {
        throwRuntimeException();
    }

    public static void main(final String... args) {
        System.out.println("Hello, world!");
    }

    public static void throwRuntimeException() {
        throw new RuntimeException("Ouch!");
    }
}

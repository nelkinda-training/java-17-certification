public class Casts {
    public static void main(final String... args) {
        final String s = "foo";
        final Object o = s; // upcast - ok
        // final String s2 = o; // does not compile - downcast requires type check
        final String s2 = (String) o; // compiles - downcast with explicit type check, and runs - "foo" is a String
        final Integer i = 42;
        final Object o2 = i; // upcast - ok
        final String s3 = (String) o2; // compiles - downcast with explicit type check, but throws an exception - 42 is not a String
    }
}

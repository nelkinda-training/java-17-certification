import java.util.List;


class Car {}

public class Strings {
    public static void main(final String... args) {
        String s1 = "foo"; // "foo" is a String literal, and thus is internalized.
        String s2 = "foo"; // This "foo" String literal points to the very same as the previous one.
        Car c1 = new Car();
        Car c2 = new Car();
        s1 += "bar"; // Re-assigns s1 to point to a new String created from concatenating "foo" and "bar".
        System.out.println(s2); // Prints "foo"

        // StringBuilder: not synchronized, fast, but not thread-safe
        StringBuilder sb1 = new StringBuilder();
        sb1.append("foo");
        sb1.append("bar");
        System.out.println(sb1); // Prints "foobar"

        // StringBuffer: synchronized, slow, but thread-safe
        StringBuffer sb2 = new StringBuffer();
        sb2.append("foo");
        sb2.append("bar");
        System.out.println(sb2); // Prints "foobar"

        List<CharSequence> strings = List.of(s1, s2, sb1, sb2);

        List<Appendable> appendables = List.of(sb1, sb2);
    }
}

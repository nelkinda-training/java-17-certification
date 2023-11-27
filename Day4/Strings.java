public class Strings {
    // What motivated the designers of Java (language and API) to make Strings immutable? Answer: Security (and also Safety)
    public static void main(final String... args) {
        String hello = "Hello, world!";
        System.out.println(hello);
        hello = "Foobar";
        System.out.println(hello);
        hello = String.valueOf(20);
        System.out.println(hello);

        for (int i = 0; i < hello.length(); i++)
            System.out.write(hello.charAt(i)); // BAD CODE! DON'T COPY THIS!
        System.out.flush();

        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + ", " + s2 + "!";
        System.out.println(s3);
    }
}

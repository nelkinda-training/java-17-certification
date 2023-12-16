public class Strings2 {
    public static void main(final String... args) {
        String hello = "Hello, world!";
        String helloInLowerCase = hello.toLowerCase(); // Strings are immutable, this doesn't change "Hello, world!"
        System.out.println(hello); // What is this printing? Hello, world!
        System.out.println(helloInLowerCase); // hello, world!
    }
}

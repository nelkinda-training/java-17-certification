class Car {}

public class Internalization {
    public static void main(final String... args) {
        String s1 = "foo";
        String s2 = "foo";
        System.out.println(s1 == s2); // true because String literals are internalized, thus s1 and s2 are references to the same object.
        Car c1 = new Car();
        Car c2 = new Car();
        System.out.println(c1 == c2); // false because those two Cars are two different objects.

        String s3 = "f";
        String s4 = "oo";
        String s5 = s3 + s4;
        String s6 = "foo";
        System.out.println(s5 == s6); // false because the results of String concatenation are not internalized, thus s5 is a new String object.

        String s7 = s5.intern();
        System.out.println(s7 == s6); // true because s7 is an explicitly internalized String

        Integer i1 = 100; // Integer i1 = Integer.valueOf(100); // returns Integer(100) from the pool
        Integer i2 = 100; // Integer i2 = Integer.valueOf(100); // returns the same Integer(100) from the pool
        System.out.println(i1 == i2); // true because 100 is in the pool of predefined Integer objects.

        Integer i3 = 10_000; // Integer i3 = Integer.valueOf(10_000); // creates a new Integer(100)
        Integer i4 = 10_000; // Integer i4 = Integer.valueOf(10_000); // creates a new Integer(100)
        System.out.println(i3 == i4); // false because 10000 is not in the pool of predefined Integer objects.

        Boolean b1 = true; // Boolean b1 = Boolean.valueOf(true); // returns Boolean.TRUE
        Boolean b2 = true; // Boolean b2 = Boolean.valueOf(true); // returns Boolean.TRUE
        System.out.println(b1 == b2); // true because Boolean.valueOf() will only ever return one of two predefined objects.

        Boolean b3 = new Boolean(true);
        Boolean b4 = new Boolean(true);
        System.out.println(b3 == b4); // false because I have explicitly created two distinct objects.
    }
}

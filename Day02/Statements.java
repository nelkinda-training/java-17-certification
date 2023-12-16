public class Statements {
    public static void main(final String... args) {
        int a = 0, b = 0, c = 0;
        System.out.println("Hello, world!");
        a = b; // expression with side-effect
        //a == b; // expression WITHOUT side-effect, not allowed as statement
        a++; // expression with side-effect
        //a++ == b++; // expression WITHOUT side-effect, not allowed as statement
        compare(a, b); // allowed, this function has no side-effect, but that's "not known" to the compiler

        b = 1000;
        System.out.format("%d %d%n", a, b);
        if (a > b)
            System.out.println("a is greater than b.");
        else
            System.out.println("b is greater than or equal a.");

        for (int i = 0; i < 10; i++)
            System.out.println(i);

        {
            int i = 0;
            while (i < 10) {
                System.out.println(i);
                i++;
            }
        }
    }

    public static boolean compare(int a, int b) {
        System.out.println("a and b are " + (a == b ? "" : "not ") + "equal.");
        return a == b;
    }

    // Function without side-effects
    public static int sum(final int... numbers) {
        int sum = 0;
        for (final int number : numbers) sum += number;
        return sum;
    }

    // Function with incoming side-effect
    public static int sum2(final int... numbers) {
        int sum = 0;
        for (final int number : numbers) sum += number;
        sum += (int) System.currentTimeMillis(); // incoming side-effect
        return sum;
    }

    // Function with outgoing side-effect
    public static int sum3(final int... numbers) {
        int sum = 0;
        for (final int number : numbers) sum += number;
        System.out.println("sum was: " + sum); // outgoing side-effect
        return sum;
    }



}

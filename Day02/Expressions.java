public class Expressions {

    public static int sum(final int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum += numbers[i];
        return sum;
    }

    public static void main(final String... args) {
        {
            int a = 10;
            int b = 20;
            int c = 30;
            int d = 40;
            int e = (a + b) * (c + d);
            int f = a * b + c * d;
        }

        {
            int a = 10;
            int b = a++;
            System.out.format("a=%d b=%d%n", a, b); // a=11 b=10
        }

        {
            int a = 10;
            int b = ++a;
            System.out.format("a=%d b=%d%n", a, b); // a=11 b=11
        }

        {
            int a = 1;
            int b = ++a + a++ + ++a;
            System.out.format("a=%d b=%d%n", a, b); // a=4 b=8
        }

        {
            int a = 42;
            int b = -a;
            int c = +a;
            System.out.format("a=%d b=%d c=%d%n", a, b, c); // a=42 b=-42 c=42
        }

        {
            int a = -42;
            int b = -a;
            int c = +a;
            System.out.format("a=%d b=%d c=%d%n", a, b, c); // a=-42 b=42 c=-42
        }

        {
            int a = 42;
            //int b = !a; // Does not compile because for !a, a MUST be of type boolean but is of type int
            //System.out.format("a=%d b=%d%n", a, b); // 
        }

        {
            int a = 42;
            int b = ~a;
            System.out.format("a=%d b=%d%n", a, b); // a=42 b=-43
            //  42 in binary: 0b00000000_00000000_00000000_00101010
            // -43 in binary: 0b11111111_11111111_11111111_11010101
        }

        {
            int a = 44;
            int b = 3;
            int c = a * b;
            int d = a / b;
            int e = a % b;
            System.out.format("a=%d b=%d c=%d d=%d e=%d%n", a, b, c, d, e); // a=44 b=3 c=132 d=14 e=2
        }

        {
            int a = 42;
            int b = a << 2; // a * 4
            int c = a >> 2; // a / 4
            int d = a >>> 2; // a / 4
            System.out.format("a=%d b=%d c=%d d=%d%n", a, b, c, d); // a=42 b=168 c=10 d=10
        }

        {
            int a = -42;
            int b = a << 2;
            int c = a >> 2;
            int d = a >>> 2;
            System.out.format("a=%x b=%x c=%x d=%x%n", a, b, c, d); // a=-42 b=-168 c=-11 d=1073741813
            // a = 0b11111111_11111111_11111111_11010110 -42
            // b = 0b11111111_11111111_11111111_01011000 -168
            // c = 0b11111111_11111111_11111111_11110101 -11
            // d = 0b00111111_11111111_11111111_11110101 1073741813
        }

        {
            int a = 42;
            int b = 54;
            boolean c = a < b;
            System.out.format("a=%d, b=%d, c=%s%n", a, b, c);
        }

        {
            int a = 42, b = 42;
            boolean c = a == b;
            System.out.format("a=%s, b=%s, c=%s%n", a, b, c); // a=42 b=42 c=true
        }

        {
            int a = 42000, b = 42000;
            boolean c = a == b;
            System.out.format("a=%s, b=%s, c=%s%n", a, b, c); // a=42000 b 42000 c=true
        }

        {
            Integer a = 42, b = 42; // Integer a = Integer.valueOf(42), b = Integer.valueOf(42);
            boolean c = a == b;
            System.out.format("a=%s, b=%s, c=%s%n", a, b, c); // a=42 b=42 c=true
        }

        {
            Integer a = 42000, b = 42000;
            boolean c = a == b;
            System.out.format("a=%s, b=%s, c=%s%n", a, b, c); // a=42000 b=42000 c=false
        }

        // List of all Java operators in order of precedence (highest first)
        // unary postfix expr++ expr--
        // unary prefix ++expr --expr +expr -expr !expr ~expr
        // arithmetic multiplicative  * / %
        // arithmetic additive + -
        // shift << >> >>>
        // relational < > <= >= instanceof
        // equality == !=
        // bitwise AND &
        // bitwise XOR ^
        // bitwise OR |
        // logical AND &&
        // logical OR ||
        // ternary ?:
        // assignment = += -= *= /= %= &= ^= |= <<= >>= >>>=
        //
        // What about cast?
        // What about -> (Lambda Expression)
    }
}

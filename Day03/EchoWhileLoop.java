public class EchoWhileLoop {
    public static void main(final String... args) {
        int i = 0;
        while (i < args.length) {
            System.out.println(args[i]);
            i++;
        }
    }
}

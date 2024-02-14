public class EffectivelyFinal {
    public static void someMethod() {
        final String[] args = { "1", "2", "3" }; // args: final (explicit)
        String[] something = args; // something: effectively final (never changes)
        String[] somethingElse = args; // somethingElse: not final
        somethingElse = null;
        new Runnable() {
            public void run() {
                System.out.println(args);
                System.out.println(something);
                System.out.println(somethingElse);
            }
        };
    }
}

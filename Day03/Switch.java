public class Switch {
    public static void main(final String... args) {
        if (args.length < 1) {
            System.err.println("Usage: java Switch <command>");
            System.exit(1);
        }
        final String command = args[0];
        switch (command) {
        case "init":
            init(args);
            break;
        case "clone":
            clone(args);
            break;
        case "push":
            push(args);
            break;
        default:
            System.err.println("Unknown command: " + command);
            System.exit(1);
        }
    }
    public static void init(final String... args) {
        // ...
    }
    public static void clone(final String... args) {
        // ...
    }
    public static void push(final String... args) {
        // ...
    }
}

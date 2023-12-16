import java.util.*;
import java.util.function.*;

public class NoSwitch {
    private static Map<String, Consumer<String[]>> methods = Map.of(
        "init",  NoSwitch::init,
        "clone", NoSwitch::clone,
        "push",  NoSwitch::push,
        "pull",  NoSwitch::pull
    );

    public static void main(final String... args) {
        if (args.length < 1) {
            System.err.println("Usage: java Switch <command>");
            System.exit(1);
        }
        final String command = args[0];
        final Consumer<String[]> consumer = methods.get(command);
        if (consumer != null)
            consumer.accept(args);
        else {
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
    public static void pull(final String... args) {
        // ...
    }
}

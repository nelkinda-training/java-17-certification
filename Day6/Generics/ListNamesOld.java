import java.util.ArrayList;
import java.util.List;

class ListNamesOld {
    public static void main(final String... args) {
        final List<String> names = generateNames();
        printNameLengths(names);
    }

    public static void printNameLengths(final List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            final Object o = names.get(i);
            final String name = (String) o;
            System.out.println(name.length());
        }
    }

    public static List<String> generateNames() {
        final List<String> names = new ArrayList<String>();
        names.add("foo");
        names.add("bar");
        // names.add(new StringBuilder()); // Compile error because StringBuilder isn't String
        // names = new ArrayList<>(); // Compile error because names is final
        return names;
    }
}

import java.util.*;

class FundamentalCollectionClasses {
public class Permissions {
    static String PERMISSION_CREATE_USER = "createUser";
    static String PERMISSION_DELETE_USER = "deleteUser";
    // ...
    // Question: Which datatype to hold permissions?
    // class User {
    //      Set<String> permissions;
    // }

    public static void main(final String... args) {
        var list1 = new ArrayList<String>(); // mutable arraylist
        var list2 = List.of<String>(); // immutable arraylist ⇐ This should be your preferred way!

        // Interfaces:
        List<T>; // Duplicates, Insertion-order
        Set<T>; // No duplicates, Unordered
        SortedSet<T> extends Set<T>; // No duplicates, unordered, but sorted

        Map<K, V>;
        SortedMap<K, V> extends Map<K, V>;
        Map.Entry<K, V>;

        // Classes:
        ArrayList<T> implements List<T>; // unsynchronized
        LinkedList<T> implements List<T>;
        Vector<T> implements List<T>; // synchronized
        Stack<T> extends Vector<T>;

        HashSet<T> implements Set<T>;
        TreeSet<T> implements SortedSet<T>;

        HashMap<K, V> implements Map<K, V>;
        TreeMap<K, V> implements SortedMap<K, V>;
    }
}

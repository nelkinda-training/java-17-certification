public class MyLinkedList<T> {
    private T theElement;
    public void add(T s) {
        theElement = s;
    }
    public T getHead() {
        return theElement;
    }

    public static <X> MyLinkedList<X> listOf(X element) {
        final MyLinkedList<X> list = new MyLinkedList<>();
        list.add(element);
        return list;
    }
}

class Main {
    public static void main(final String... args) {
        final MyLinkedList<String> list1 = new MyLinkedList<>();
        final MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list1.add("foo");
        list2.add(42);
        //list1.add(42); // Compile-time error: 42 is not a String
        //list2.add("foo"); // Compile-time error: "foo" is not an Integer
        final var list3 = MyLinkedList.listOf("foo"); // type infered - String
        final var list4 = MyLinkedList.<Integer>listOf(42); // type explicit - Integer (but could be infered)
    }
}

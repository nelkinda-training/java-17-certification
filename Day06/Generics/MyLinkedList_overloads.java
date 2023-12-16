public class MyLinkedList {
    private Object theElement;
    public void add(String s) {
        theElement = s;
    }
    public void add(int n) {
        theElement = n;
    }
    public String getHeadString() {
        return (String) theElement;
    }
    public int getHeadInt() {
        return (int) theElement;
    }
}

class Main {
    public static void main(final String... args) {
        final MyLinkedList list = new MyLinkedList();
        list.add("foo");
        System.out.println(42);
        System.out.println(list.getHeadInt());
    }
}

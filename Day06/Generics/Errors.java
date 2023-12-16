import java.util.ArrayList;
import java.util.List;

public class Errors {
    public static void main(final String... args) {
        final List<String> list1 = new ArrayList<String>();
        //final String number = 5; // Compiler error because int does not extend or implement String
        //final List<String> list2 = new ArrayList<Integer>(); // Compiler error because Integer does not extend or implement String
        final List<Object> list3 = getMyList(); // Does not compile - no upcasting of type parameters
        list3.add(new Object());

        final List<String> list4 = getTheOtherList(); // Does not compile - no downcasting of type parameters
        for (final String string : list4) {
            System.out.println(string.length());
        }
    }


    public static final ArrayList<Object> getTheOtherList() {
        final ArrayList<Object> theOtherList = new ArrayList<Object>();
        theOtherList.add(new Object());
        return theOtherList;
    }

    private static final ArrayList<String> thatList = new ArrayList<String>();
    public static ArrayList<String> getMyList() {
        return thatList;
    }

    public static void printStringLengthsFromThatList() {
        for (final String string : thatList) {
            System.out.println(string.length());
        }
    }
}

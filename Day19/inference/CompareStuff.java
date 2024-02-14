import java.util.Comparator;

class CompareStuff {
    public static void main(final String... args) {
        Comparator<String> c1 = (j, k) -> 0;
        Comparator<String> c2 = (String j, String k) -> 0;
        Comparator<String> c3 = (var j, String k) -> 0;
        Comparator<String> c4 = (var j, k) -> 0;
        Comparator<String> c5 = (var j, var k) -> 0;
        Comparator<String> c6 = (String j, k) -> 0;
    }
}

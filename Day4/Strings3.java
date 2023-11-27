public class Strings3 {
    private static Map<String, String> internalizedPool = new HashMap<String, String>();

    public static void main(final String... args) {
        String s1 = "Hello"; // ID1: "Hello" in the internalized pool

        String s2 = "Hello"; // ID1: "Hello" in the internalized pool
        if (s1 == s2) {
            System.out.println("s1 == s2: true"); // Printed
        } else {
            System.out.println("s1 == s2: false"); // Not printed
        }

        String s3 = "H"; // ID2: "H" in the internalized pool
        String s4 = "ello"; // ID3: "ello" in the internalized pool
        String s5 = s3 + s4; // ID4: "Hello" on the heap
        if (s1 == s5) {
            System.out.println("s1 == s5: true");
        } else {
            System.out.println("s1 == s5: false"); // Printed
        }

        String s6 = s5.intern(); // ID1: "Hello" in the internalized pool
        if (s1 == s6) {
            System.out.println("s1 == s6: true"); // Printed
        } else {
            System.out.println("s1 == s6: false");
        }
    }
}

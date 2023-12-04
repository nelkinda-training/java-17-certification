public class Reverse {
    public static void main(final String... args) {
        String s1 = "ab";
        String s2 = s1.reverse();
        System.out.println(s1);
        System.out.println(s2);
    }
}

// What does this code print?
// A. ab ba
// B. ab ab
// C. ba ab
// D. ba ba
// E. None of the above

// Correct answer: E. There is no String.reverse() method, line 4 will fail to compile.

public class DefParam {
    public static void main(final String... args) {
        defParamFunction();
        defParamFunction("foo");
    }
    public static void defParamFunction(String v = "42") {
        System.out.println(v);
    }
}

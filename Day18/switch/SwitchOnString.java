class SwitchOnString {
    public static void main(final String... args) {
        switch (args[0]) {
            case "foo": System.out.println("bar"); break;
            default: System.out.println(args[0]);
        }
    }
}

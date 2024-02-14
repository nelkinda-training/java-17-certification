class SwitchOnBoolean {
    public static void main(final String... args) {
        var x = true;
        switch (x) { // Does not compile, not possible to switch on boolean
            case true: System.out.println("True"); break;
            case false: System.out.println("False"); break;
        }
    }
}

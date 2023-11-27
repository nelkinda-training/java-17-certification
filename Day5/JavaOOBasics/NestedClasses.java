class Outer {
    int instanceField = 0;
    static int staticField = 0;

    class InstanceInner {
        int instanceField = 0;
        // static int staticField = 0; // Compile-time error: Instance inner classes cannot have static members
    }

    public static class StaticInner {
        int instanceField = 0;
        static int staticField = 0;
    }
}

class Main {
    public static void main(final String... args) {
        new Outer();
        new Outer.StaticInner();
        new Outer().new InstanceInner();
        Outer o = new Outer();
        Outer.InstanceInner i = o.new InstanceInner();
    }
}

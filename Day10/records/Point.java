interface HasLength {
    double getLength();
}

// Records can implement interfaces
record Point(double d1, double d2) implements HasLength {
    // Records can overload constructors
    Point(int i1, int i2) {
        this((double) i1, (double) i2);
    }

    public double getLength() {
        return Math.sqrt(d1 * d1 + d2 * d2);
    }

    record NestedRecord() {} // implicitly static (!)
}

class Main {
    public static void main(final String... args) {
        System.out.println(new Point.NestedRecord());
    }
}

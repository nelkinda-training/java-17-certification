import java.awt.Color;
import java.util.Objects;

class Point {
    protected final int x;
    protected final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Point[x=%d, y=%d]", x, y);
    }

    @Override
    public final boolean equals(final Object o) {
        // x.equals(null) is always false
        if (o == null) return false;

        // Can o belong to the same equivalence class by type?
        if (!(o instanceof Point p)) return false; // polymorphic equivalence - subclasses are in the same a equivalence class
                                                 // Overriding equals() in subclass can break LSP or Object.equals() contract.
                                                 // Counter-measure: Make equals() and hashCode() inal.
        return x == p.x && y == p.y;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(x, y);
    }
}

class PointWithColor extends Point {
    private Color color;
    public PointWithColor(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public Color color() {
        return color;
    }

    //@Override
    //public boolean equals(final Object o) {
    //    // x.equals(null) is always false
    //    if (o == null) return false;

    //    // Can o belong to the same equivalence class by type?
    //    if (!(o instanceof PointWithColor)) return false; // polymorphic equivalence - subclasses are in the same a equivalence class
    //                                             // Overriding equals() in subclass can break LSP or Object.equals() contract.
    //                                             // Counter-measure: Make equals() and hashCode() inal.
    //    PointWithColor p = (PointWithColor) o;
    //    return x == p.x && y == p.y && color.equals(p.color);
    //}

    //@Override
    //public int hashCode() {
    //    return Objects.hash(x, y, color);
    //}
}

class Main {
    public static void main(final String... args) {
        final Point p1 = new Point(2, 3);
        final Point p2 = new Point(2, 3);
        final Point p3 = new PointWithColor(2, 3, Color.RED);
        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2)); // only prints true if I implemented a correct equals() method
        System.out.println("V1: " + p1.equals(p3));
        System.out.println("V2: " + p3.equals(p1) + " (should be the same as V1)");
    }
}

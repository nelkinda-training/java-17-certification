import java.awt.Color;
import java.util.Objects;

class Point {
    private final int x;
    private final int y;

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
    public boolean equals(final Object o) {
        // x.equals(null) is always false
        if (o == null) return false;

        // Can o belong to the same equivalence class by type?
        if (!o.getClass().equals(getClass())) return false; // non-polymorphic equivalence - subclasses are a different equivalence class
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
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

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!o.getClass().equals(getClass())) return false;
        PointWithColor p = (PointWithColor) o;
        return x() == p.x() && y() == p.y() && Objects.equals(color, p.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x(), y(), color);
    }
}

class Main {
    public static void main(final String... args) {
        final Point p1 = new Point(2, 3);
        final Point p2 = new Point(2, 3);
        final Point p3 = new PointWithColor(2, 3, Color.RED);
        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2)); // only prints true if I implemented a correct equals() method
        System.out.println(p1.equals(p3));
        System.out.println(p3.equals(p1));
    }
}

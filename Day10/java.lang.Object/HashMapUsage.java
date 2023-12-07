import java.util.*;

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

class Main {
    public static void main(final String... args) {
        Map<Point, Object> universe = new HashMap<>();
        universe.put(new Point(0, 0), "Origin");
        universe.put(new Point(0, 1), "A big black hole");

        System.out.println(universe.get(new Point(0, 0)));
        System.out.println(universe.get(new Point(0, 1)));
    }
}

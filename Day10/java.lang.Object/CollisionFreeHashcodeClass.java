import java.util.*;

// Warning: Don't do this.
// A. It's not worth it.
// B. This has race conditions.
// C. Nobody does it this way.
// D. It wastes a lot of memory.
final class Point {
    private static int lastHash = 1;
    private static List<Point> allPoints = new ArrayList<>();

    private int x;
    private int y;
    private int hashCode;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
        for (final Point p : allPoints) {
            if (equals(p)) {
                hashCode = p.hashCode;
                return;
            }
        }
        hashCode = generateNewHashcode(this);
    }

    private static synchronized int generateNewHashcode(Point p) {
        allPoints.add(p);
        return ++lastHash;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof Point)) return false;
        final Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
}

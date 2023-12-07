import java.util.Objects;

record Dimension(int width, int height) {
    public int length() {
        return (int) Math.sqrt(height * height + width * width);
    }
}

class DimensionClass {
    private final int width;
    private final int height;
    public DimensionClass(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!o.getClass().equals(getClass())) return false;
        DimensionClass d = (DimensionClass) o;
        return d.width == width && d.height == height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}

class Main {
    public static void main(final String... args) {
        Dimension d1 = new Dimension(10, 20);
        Dimension d2 = new Dimension(10, 20);
        System.out.println(d1);
        System.out.format("width: %d, height: %d%n", d1.width(), d1.height());
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
    }
}

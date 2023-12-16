import java.awt.Color;

interface HasColor {
    Color RED = new Color(255, 0, 0); // Implicitly public static final

    Color getColor(); // Implicitly public abstract

    default void printNameToStdout() { // Implicitly public
        System.out.println(getColor());
    }

    static Color parseColor(String c) { // Implicitly public
        return null;
    }

    private Color parseRGB(String rgb) {
        return null;
    }
}

interface HasName {
    String getName();

    default void printNameToStdout() {
        System.out.println(getName());
    }
}

interface HasColorAndName extends HasColor, HasName {
    default void printNameToStdout() {
        HasColor.super.printNameToStdout();
        HasName.super.printNameToStdout();
        System.out.println(getColor() + " " + getName());
    }
}

class MyCircle implements HasColorAndName {
    private Color color;
    private String name;

    public MyCircle(final Color color, final String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}

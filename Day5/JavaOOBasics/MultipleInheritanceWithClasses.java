import java.awt.Color;

class HasColor {
    private Color color;

    HasColor(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

class HasName {
    private String name;

    HasName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//class HasColorAndName extends HasColor, HasName { // Not possible in Java
//}

import java.awt.Color;

public class DisplayColor {
    public static Color displayColor1(int stock) {
        if (stock < 5) return color("warning");
        else return color("normal");
    }

    public static Color displayColor2(int stock) {
        String colorCode;
        if (stock < 5) colorCode = "warning";
        else colorCode = "normal";
        return color(colorCode);
    }

    public static Color displayColor3(int stock) {
        return color(stock < 5 ? "warning" : "normal");
    }

    public static Color color(String code) {
        switch (code) {
            case "warning": return Color.RED;
            case "normal": return Color.BLACK;
            default: return Color.BLACK;
        }
    }
}

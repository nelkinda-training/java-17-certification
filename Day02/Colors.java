public class Colors {
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

    public static void main(final String... args) {
        if (args.length == 3) {
            int red = Integer.parseInt(args[0]);
            int green = Integer.parseInt(args[1]);
            int blue = Integer.parseInt(args[2]);
            System.out.println("#" + toHex(red >> 4) + toHex(red) + toHex(green >> 4) + toHex(green) + toHex(blue >> 4) + toHex(blue));
        }
        if (args.length == 1) {
            int rgb = Integer.parseInt(args[0], 16); // ff00aa
            int red   = (rgb & 0xff0000) >> 16; // ff
            int green = (rgb & 0x00ff00) >>  8; // 00
            int blue  = (rgb & 0x0000ff) >>  0; // aa
            System.out.format("%d %d %d%n", red, green, blue);
        }
    }
    public static char toHex(final int num) {
        return HEX_CHARS[num & 0xF];
    }
}

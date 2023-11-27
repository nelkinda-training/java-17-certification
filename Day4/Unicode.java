public class Unicode {
    public static void main(final String... args) {
        // ASCII (US-ASCII-7)
        // 0..127
        final String thankYou = new StringBuilder().appendCodePoint(0x1F64F).toString();
        System.out.println(thankYou);
        for (char c : thankYou.toCharArray()) {
            System.out.format("%04x ", (int) c); // d83d de4f
        }
        System.out.println();

        // char is UTF-16

        // UTF-8
        // 0nnn_nnnn                                 0x00 ..     0x7F     0 ..   127 1-Byte ASCII-compatible encoding
        // 110n_nnnn 10nn_nnnn                       0x7F ..    0x7FF   128 ..  2047 2-Byte encoding
        // 1110_nnnn 10nn_nnnn 10nn_nnnn            0x7FF ..   0xFFFF  2048 .. 65535 3-Byte encoding
        // 1111_0nnn 10nn_nnnn 10nn_nnnn 10nn_nnnn 0xFFFF .. 0x1FFFFF                4-Byte encoding
        //
        // DF
        // 1101 1111
        // C3 9F
        // 1100 0011 1001 1111 -> 1101 1111 DF
        // 110n_nnnn 10nn_nnnn
        //    0 0011   01 1111
        //           1101 1111  DF
        //
        // 🪔 f0  9f  aa  94
        // 1111 0000 1001 1111 1010 1010 1001 0100
        // 1111_0nnn 10nn_nnnn 10nn_nnnn 10nn_nnnn
        //       000   01 1111   10 1010   01 0100
        //       0 0001 1111 1010 1001 0100
        //           1     F    A    9    4
    }
}

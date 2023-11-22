public class Types {
    public static void main(final String... args) {
        // Let's list all primitive types of Java
        // int, byte, short, char, long, double, boolean, float
        //
        // byte     8 Bits      -128 (-2^7)     127 (2^7-1)     int8_t
        // short    16 Bits     -32768 (-2^15)  32767 (2^15-1)  int16_t
        // int      32 Bits     -2^31           2^31-1          int32_t
        // long     64 Bits     -2^63           2^63-1          int64_t
        // char     16 Bits     0               65535           uint16_t
        // float    32 Bits     IEEE754 binary32                float
        // double   64 Bits     IEEE754 binary64                double
        // boolean  (8 Bits)    false           true            bool
        // boolean[] someBoolean = new boolean[1024]; // Array memory size (excluding overhead): 1024 bytes
        byte    myZeroByte     = 0;
        short   myZeroShort    = 0;
        int     myZeroInt      = 0;
        long    myZeroLong     = 0;
        char    myZeroChar     = 0;
        float   myZeroFloat    = 0;
        double  myZeroDouble   = 0;
        boolean myZeroBoolean  = false;

        // What is a "literal"?
        // A value that appears in the source code.
        // There are no literals for byte and short.
        // There are literals of the following types:
        // - int 0 1 2   0x0 0x1 0x2 0xF  00 01 02 017  0b0 0b1 0b10 0b1111
        // - long 0L 1l 2L
        // - float 0.0f 0.0F
        // - double 0.0
        // - char '\0' 'a'
        // - boolean false true
        // - Object null
        // - String "" """"""
        // Literal type down-promotion, only happens when the value is in range.
        byte someByte = 0x7F;
        byte someOtherByte = (byte) 0x00; // 0x00000000
        byte otherByte1 = someByte;
        byte otherByte2 = someOtherByte;
        byte otherByte3 = (byte) (0 + someByte);
        byte otherByte4 = (byte) (0 + someOtherByte);

        byte newByte = (byte) (someByte + someOtherByte);

        int someInt = 0x7FFFFFFF;
        int someOtherInt = 0x80000000;
        int newInt = someInt + someOtherInt;

        // What is type promotion?
        // int -> long -> float -> double (-> String only in case of +)
        int x = 0;
        float y = 0.0f;
        float newValue = (int) x + (float) y;
    }
}

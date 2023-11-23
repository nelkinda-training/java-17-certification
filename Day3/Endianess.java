import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Endianess {
    private static final short BYTE_ORDER_MARK = (short) 0xFFFE;

    public static void main(final String... args) {
        var buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.nativeOrder());
        buffer.putShort(BYTE_ORDER_MARK);
        buffer.rewind();
        switch (buffer.get() & 0xFF) {
        case 0xFF: System.out.println("Big Endian"); break;
        case 0xFE: System.out.println("Little Endian"); break;
        default: assert false;
        }

        switch (ByteOrder.nativeOrder()) {
        case ByteOrder.BIG_ENDIAN: System.out.println("Big Endian"); break;
        case ByteOrder.LITTLE_ENDIAN: System.out.println("Little Endian"); break;
        default: assert false;
        }
    }
}

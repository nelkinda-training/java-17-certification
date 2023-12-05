import java.util.*;
import java.io.*;

public class Base64Encoder {
    public static void main(final String... args) throws IOException {
        System.in.transferTo(Base64.getMimeEncoder().wrap(System.out));
    }
}

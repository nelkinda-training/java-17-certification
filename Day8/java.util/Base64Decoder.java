import java.util.*;
import java.io.*;

public class Base64Decoder {
    public static void main(final String... args) throws IOException {
        Base64.getMimeDecoder().wrap(System.in).transferTo(System.out);
    }
}

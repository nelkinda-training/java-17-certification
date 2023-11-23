import java.io.*;

class Cat {
    public static void main(final String... args) throws IOException {
        if (args.length == 0)
            System.in.transferTo(System.out);
        else {
            // Naïve version
            {
                int i = 0;
                while (i < args.length) {
                    try (var in = new FileInputStream(args[i])) {
                        in.transferTo(System.out);
                    }
                    i++;
                }
            }

            // Old for-loop
            for (int i = 0; i < args.length; i++)
                try (var in = new FileInputStream(args[i])) {
                    in.transferTo(System.out);
                }
            // endless-loop with while: while (true)
            // endless-loop with for: for (;;)

            // foreach-loop (Java 5)
            for (String arg : args)
                try (var in = new FileInputStream(arg)) {
                    in.transferTo(System.out);
                }

            // foreach-loop with var
            for (var arg : args)
                try (var in = new FileInputStream(arg)) {
                    in.transferTo(System.out);
                }
        }
    }
}

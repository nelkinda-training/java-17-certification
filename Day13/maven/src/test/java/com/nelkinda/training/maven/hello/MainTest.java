package com.nelkinda.training.maven.hello;

import java.io.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testMain() throws IOException {
        final ByteArrayOutputStream interceptedStdout = new ByteArrayOutputStream();
        final PrintStream originalStdout = System.out;
        try {
            System.setOut(new PrintStream(interceptedStdout));
            Main.main();
            assertEquals("Hello, world!\n", interceptedStdout.toString());
        } finally {
            System.setOut(originalStdout);
        }
    }
}

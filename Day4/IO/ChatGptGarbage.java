import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// This was the ChatGPT Prompt:
// Show me a java program that can copy any data from stdin to stdout.
//
// Lesson: Don't ask ChatGPT for help, or if you do, DO NOT TRUST IT!

public class ChatGptGarbage {
    public static void main(String[] args) {
        try {
            // Create a BufferedReader to read from stdin
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BUG: Can't copy _any_ data, only text

            // Create a StringBuilder to store the input data
            StringBuilder inputData = new StringBuilder();

            // Read input from stdin until an empty line is encountered
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) { // BUG: Don't stop at empty line
                inputData.append(line).append("\n"); // BUG: Converting CRLF to LF-only and appending a stray LF at the last line if incomplete
            }

            // Close the BufferedReader
            reader.close();

            // Write the input data to stdout
            System.out.println(inputData.toString()); // BUG: Adds additional LF or CRLF to the output.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

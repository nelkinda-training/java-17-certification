import java.io.*;
import java.net.*;

public class WebServer {
    public static void main(final String... args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final String requestLine = in.readLine();
                    final OutputStream out = socket.getOutputStream();
                    out.write("HTTP/1.0 200 Ok\r\nContent-Type: text/html\r\n\r\nHello, world!".getBytes());
                    out.close();
                } catch (final IOException e) {
                    System.err.println(e);
                }
            }).start();
        }
    }
}

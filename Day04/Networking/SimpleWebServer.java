import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class SimpleWebServer {
    public static void main(final String... args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        System.err.println("info: server running on port: " + server.getAddress().getPort());
        server.createContext("/", (exchange) -> {
            try {
                exchange.sendResponseHeaders(200, 0);
                exchange.getResponseBody().write("Hello, world!".getBytes());
                exchange.close();
            } catch (final IOException e) {
                System.err.println(e);
            }
        });
        //server.setExecutor(null); // creates a default executor
        server.start();
    }
}

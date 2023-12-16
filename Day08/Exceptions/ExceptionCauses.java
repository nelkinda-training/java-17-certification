import java.net.*;
import java.io.*;

public class ExceptionCauses {
    public static void main(final String... args) throws ServerStartFailed {
        final MyServer server = new MyServer("http://localhost:80/");
        while (true);
    }

    static class MyServer {
        private ServerSocket serverSocket;

        MyServer(final String uri) throws ServerStartFailed {
            this(URI.create(uri));
        }
        MyServer(final URI uri) throws ServerStartFailed {
            if (!"http".equals(uri.getScheme())) throw new ServerStartFailed("Scheme must be http but was " + uri.getScheme());
            if (uri.getHost() == null) throw new ServerStartFailed("URI did not have a host");
            if (uri.getPort() == -1) throw new ServerStartFailed("URI did not have a port");
            try {
                serverSocket = new ServerSocket(uri.getPort());
            } catch (IOException e) {
                throw new ServerStartFailed("Couldn't start server because of unexpected IOException", e);
            }
        }
    }

    static class ServerStartFailed extends Exception {
        ServerStartFailed() {
            super();
        }
        ServerStartFailed(String message) {
            super(message);
        }
        ServerStartFailed(String message, Throwable cause) {
            super(message, cause);
        }
        ServerStartFailed(Throwable cause) {
            super(cause);
        }
    }
}

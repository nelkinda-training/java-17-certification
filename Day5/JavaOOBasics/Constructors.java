class Super {
    public Super(String name) {
        super();
    }
    public void printMe() {
        System.out.println("Super");
    }
}

class Sub extends Super {
    public Sub() {
        super("");
    }
    public void printMe() {
        super.printMe();
        System.out.println("Sub");
    }
}

class HttpServer {
    public static final int DEFAULT_PORT = 80;

    private final int port;

    public HttpServer() {
        this(DEFAULT_PORT);
    }

    public HttpServer(final int port) {
        this.port = port;
    }
    public int getPort() {
        return this.port;
    }
}

class Main {
    public static void main(final String... args) {
        Sub sub = new Sub();
        Super sup = new Super("name");
    }
}

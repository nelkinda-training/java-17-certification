class InstanceInit {
    {
        System.out.println("Hello, world!");
    }

    private int something = 42;
    InstanceInit() {
        System.out.println(something);
    }
}

class Main {
    public static void main(final String... args) {
        new InstanceInit();
    }
}

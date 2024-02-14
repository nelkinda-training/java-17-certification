abstract class Foo {
    protected final String text;
    protected Foo(final String text) {
        this.text = text;
    }

    public abstract void doSomething();

    public static void main(final String... args) {
        Foo TRUE  = new Foo("1") { public void doSomething() { System.out.println("TRUE "  + text); } };
        Foo FALSE = new Foo("2") { public void doSomething() { System.out.println("FALSE " + text); } };
        TRUE.doSomething();
        FALSE.doSomething();
    }
}

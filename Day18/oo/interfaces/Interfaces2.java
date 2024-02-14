@FunctionalInterface
interface Lion {
   public void roar();
   default void drink() {}
   String toString();
}

@FunctionalInterface
interface Tiger {
   public void roar();
   default void drink() {}
   int hashCode();
}

class Main {
    public static void main(final String... args) {
        Lion  lion  = () -> { System.out.println("Roar!"); };
        Tiger tiger = () -> { System.out.println("Roar!"); };
    }
}

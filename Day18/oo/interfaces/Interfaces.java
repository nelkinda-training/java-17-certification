








interface Flavor {
   public default void happy() {
      printFlavor("Rocky road");
   }
   private static void excited() {
      printFlavor("Peanut butter");
   }
   private void printFlavor(String f) {
      System.out.println("Favorite Flavor is: "+f);
   }
   public static void sad() {
      printFlavor("Butter pecan");
   }
}
class IceCream implements Flavor {
   @Override public void happy() {
      printFlavor("Cherry chocolate chip");
   } }

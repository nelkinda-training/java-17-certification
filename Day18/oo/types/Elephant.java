package stampede;
interface Long {
   Number length();
}
public class Elephant {
   public class Trunk implements Long {
      public Number length() { return 6; }   // k1
   }
   public class MyTrunk extends Trunk {      // k2
      public Integer length() { return 9; }  // k3
   }
   public static void charge() {
      System.out.print(new MyTrunk().length());
   }
   public static void main(String[] cute) {
      new Elephant().charge();               // k4
   } }

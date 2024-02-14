class Math {
   double secret = 2;
   double otherSecret() {
       return -2.0;
   }
}
class ComplexMath extends Math {
   double secret = 4;
   double otherSecret() {
       return -4.0;
   }
}
class InfiniteMath extends ComplexMath {
   double secret = 8;
   double otherSecret() {
       return -8.0;
   }
   public static void main(String[] numbers) {
      Math math = new InfiniteMath();
      System.out.println(math.secret);
      System.out.println(math.otherSecret());
   } }

public record Light(String type, float lumens) {
   final static String DEFAULT_TYPE = "PAR";
   public Light {
      if(type == null)
         throw new IllegalArgumentException();
      else type = DEFAULT_TYPE;
   }
   public Light(String type) {
      this.type = "B";
      this.lumens = 10f;
   }
   public static void main(String[] p) {
      final var bulb = new Light("A", 300);
      System.out.print(bulb.type());
   } }


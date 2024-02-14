public record Disco(int beats) {
   public Disco(String beats) {
      this(20);
   }
   public Disco {
      beats = 10;
   }
   public int getBeats() {
      return beats;
   }
   public static void main(String[] args) {
      System.out.print(new Disco(30).beats());
   } }

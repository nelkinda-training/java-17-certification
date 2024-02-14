public class Penguins {
    public static void main(String[] args) {
       var pen = new Penguins();
       pen.length("penguins");
       pen.length(5);
       pen.length(new Object());
   }
   public void length(Object obj) {
     if (obj instanceof String x) 
        System.out.println(x.length());
   } }

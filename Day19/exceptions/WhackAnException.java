public class WhackAnException {
   public static void main(String[] hammer) {
      try {
         throw new ClassCastException();
      } catch (IllegalArgumentException e) {
         throw new IllegalArgumentException();
      } catch (RuntimeException e) {
         throw new NullPointerException();
      } finally {
         return; // Return in normal mode, discarding exceptions
      } } }

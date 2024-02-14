import java.sql.*;
public class Bells {
   class Player implements AutoCloseable {
      @Override public void close() throws RingException {}
   }
   class RingException extends Exception {
      public RingException(String message) {}
   }
   public static void main(String[] notes) throws Throwable {
      try (Player p = null) {
         throw new Exception();
      } catch (Exception e) {
      } catch (Error q) {
      } } }

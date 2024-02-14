class TimeException extends Exception {}
class TimeMachine implements AutoCloseable {
   int v;
   public TimeMachine(int v) {this.v = v;}
   public void close() throws TimeException {
      System.out.print(v);
   } }
public class TimeTraveler {
   public static void main(String[] twelve) {
      try (var timeSled = new TimeMachine(1);
           var delorean = new TimeMachine(2);
           var tardis = new TimeMachine(3)) {
      } catch (TimeException e) {
         System.out.print(4);
      } finally {
         System.out.print(5);
      } } }

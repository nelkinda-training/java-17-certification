import java.util.concurrent.*;
public class Bank {
   static int cookies = 0;
   private static Object monitor = new Object();
   public static void deposit(int amount) {
       synchronized (monitor) {
      cookies += amount;
       }
   }
   public static void withdrawal(int amount) {
       synchronized (monitor) {
      cookies -= amount;
       }
   }
   public static void main(String[] amount) throws Exception {
      var teller = Executors.newScheduledThreadPool(50);
      Bank bank = new Bank();
      for(int i=0; i < 100; i++) {
         teller.submit(() -> bank.deposit(5));
         teller.submit(() -> bank.withdrawal(5));
      }
      teller.shutdown();
      teller.awaitTermination(10, TimeUnit.SECONDS);
      System.out.print(bank.cookies);
   } }

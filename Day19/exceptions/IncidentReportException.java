import java.io.IOException;
public class IncidentReportException extends RuntimeException {
    public IncidentReportException(Throwable cause) {
        super(cause);
    }

   public static void main(String[] args) throws Exception {
      try {
         throw new IncidentReportException(new IOException());
      } catch (RuntimeException e) {
         System.out.println(e.getCause());
      } } }

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class AnalyzeXml {
    public static void main(final String... args) throws Throwable {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        System.out.println(dbf.getClass().getName());
        final DocumentBuilder db = dbf.newDocumentBuilder();
        System.out.println(db.getClass().getName());
        final Document doc = db.newDocument();
        System.out.println(doc.getClass().getName());
    }
}

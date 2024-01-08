import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.bootstrap.*;
import org.w3c.dom.ls.*;
import java.util.UUID;

record Customer(UUID id, String name) {}

public class ReadCustomers {

    public static Document bootstrapUsingJava() throws Throwable {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);

        final DocumentBuilder db = dbf.newDocumentBuilder();

        final Document doc = db.parse(System.in);
        return doc;
    }

    public static Document bootstrapUsingDOM() throws Throwable {
        final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        final DOMImplementationLS domImplementationLS = (DOMImplementationLS) registry.getDOMImplementation("LS");
        final LSParser lsParser = domImplementationLS.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
        lsParser.getDomConfig().setParameter("comments", false);
        lsParser.getDomConfig().setParameter("element-content-whitespace", false);
        //final DOMStringList parameterNames = lsParser.getDomConfig().getParameterNames();
        //for (int i = 0; i < parameterNames.getLength(); i++) {
        //    System.err.format("%s%n", parameterNames.item(i));
        //}
        final LSInput input = domImplementationLS.createLSInput();
        input.setByteStream(System.in);
        final Document doc = lsParser.parse(input);
        return doc;
    }

    public static void main(final String... args) throws Throwable {
        //final Document doc = bootstrapUsingJava();
        final Document doc = bootstrapUsingDOM();

        final Element customers = doc.getDocumentElement();

        final NodeList customersNL = customers.getChildNodes();
        for (int i = 0; i < customersNL.getLength(); i++) {
            final Node currentNode = customersNL.item(i);
            // Is this an element?
            // Variant 1 (works in ALL languages)
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                final Element el = (Element) currentNode;
                final UUID id = UUID.fromString(el.getAttribute("id"));
                final String name = el.getFirstChild().getFirstChild().getNodeValue();
                final Customer c = new Customer(id, name);
                System.out.format("%s%n", c);
            }
            // Variant 2 (works on JVM)
            if (currentNode instanceof Element) {
            }
        }
    }
}

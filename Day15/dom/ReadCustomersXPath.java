import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.bootstrap.*;
import org.w3c.dom.ls.*;
import java.util.UUID;
import javax.xml.xpath.*;

record Customer(UUID id, String name) {}

public class ReadCustomersXPath {

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

        final XPathFactory xpathFactory = XPathFactory.newInstance();
        final XPath xpath = xpathFactory.newXPath();

        final NodeList customersNL = (NodeList) xpath.evaluate("//customer", doc, XPathConstants.NODESET);
        for (int i = 0; i < customersNL.getLength(); i++) {
            final Element customerNode = (Element) customersNL.item(i);
            final UUID id = UUID.fromString((String) xpath.evaluate("@id", customerNode, XPathConstants.STRING));
            final String name = (String) xpath.evaluate("name", customerNode, XPathConstants.STRING);
            final Customer c = new Customer(id, name);
            System.out.format("%s%n", c);
        }
    }
}

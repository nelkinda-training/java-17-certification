import javax.xml.parsers.*;
import java.util.List;
import java.util.UUID;
import org.w3c.dom.*;
import org.w3c.dom.bootstrap.*;
import org.w3c.dom.ls.*;

record Customer(UUID id, String name) {}

public class WriteCustomers {

    public static Document newDocumentJava() throws Throwable {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        final DocumentBuilder db = dbf.newDocumentBuilder();
        final Document doc = db.newDocument();
        final Element customers = doc.createElement("customers");
        doc.appendChild(customers);
        return doc;
    }

    public static Document newDocumentDOM() throws Throwable {
        final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        final DOMImplementation domImplementation = registry.getDOMImplementation("");
        final DocumentType dtd = domImplementation.createDocumentType("customers", null, "customers.dtd");
        final Document doc = domImplementation.createDocument(null, "customers", dtd);
        return doc;
    }

    public static void main(final String... args) throws Throwable {
        final List<Customer> customersList = List.of(new Customer(UUID.randomUUID(), "Neha Kulkarni"), new Customer(UUID.randomUUID(), "John DaCosta"));

        final Document doc = newDocumentDOM();
        final Element customers = doc.getDocumentElement();
        for (final Customer c : customersList) {
            final Element customer = doc.createElement("customer");
            customers.appendChild(customer);
            customer.setAttribute("id", c.id().toString());
            final Element name = doc.createElement("name");
            customer.appendChild(name);
            name.appendChild(doc.createTextNode(c.name()));
        }

        final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        final DOMImplementationLS domImplementationLS = (DOMImplementationLS) registry.getDOMImplementation("LS");
        final LSSerializer serializer = domImplementationLS.createLSSerializer();
        //final DOMStringList parameterNames = serializer.getDomConfig().getParameterNames();
        //for (int i = 0; i < parameterNames.getLength(); i++) {
        //    System.err.format("%s%n", parameterNames.item(i));
        //}
        serializer.getDomConfig().setParameter("format-pretty-print", true);
        final LSOutput output = domImplementationLS.createLSOutput();
        output.setByteStream(System.out);
        serializer.write(doc, output);
    }
}

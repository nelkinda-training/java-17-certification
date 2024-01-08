import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;

record Customer(UUID id, String name) {}

public class ReadXmlSax {
    public static void main(final String... args) throws Throwable {
        final SAXParserFactory spf = SAXParserFactory.newInstance();
        final SAXParser parser = spf.newSAXParser();
        final List<Customer> customers = new ArrayList<>();

        final DefaultHandler handler = new DefaultHandler() {
            private String id;
            private String name;
            private boolean insideCustomer;
            private boolean insideName;
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if ("customer".equals(qName)) {
                    id = attributes.getValue("id");
                    insideCustomer = true;
                }
                if ("name".equals(qName) && insideCustomer) {
                    insideName = true;
                }
            }

            public void characters(char[] ch, int start, int length) {
                if (insideName) {
                    name = new String(ch, start, length);
                }
            }

            public void endElement(String uri, String localName, String qName) {
                if ("customer".equals(qName)) {
                    customers.add(new Customer(UUID.fromString(id), name));
                    insideCustomer = false;
                }
                if ("name".equals(qName) && insideCustomer) {
                    insideName = false;
                }
            }
        };
        parser.parse(System.in, handler);

        for (final Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class SortCustomers {
    public static void main(final String... args) throws Throwable {
        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Source transformationSource = new StreamSource("sortByName.xslt");
        final Transformer transformer = transformerFactory.newTransformer(transformationSource);
        final Source dataSource = new StreamSource("customers.xml");
        final Result result = new StreamResult(System.out);
        transformer.transform(dataSource, result);
    }
}

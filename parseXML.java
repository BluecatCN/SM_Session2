import java.sql.Timestamp;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class parseXML {

    public static void main(String[] args) {

        // Load and parse XML file into DOM
        Document document = null;
        // var stringtime = null;
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        try {
            // DOM parser instance
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            // create a new document from file,parse this doc into a DOM document object
            File xmlfile = new File(".vscode/json_of_14Sep.xml");
            document = builder.parse(xmlfile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // get root element
        Element rootElements = document.getDocumentElement();

        // get the content of tagname="date"
        NodeList datelist = rootElements.getElementsByTagName("date");
        System.out.println("Hello, a new Java World! 2018-09-30 01:09");
        // System.out.println(nodes);

        var stringtime1 = datelist.item(0).getTextContent();
        // System.out.println(parseDatetimestamp(stringtime1));

        System.out.println("There has " + datelist.getLength() + " different dates");
        System.out.println("The second one is " + stringtime1);
        Timestamp ts1 = Timestamp.valueOf(stringtime1);

        long timestamp1 = ts1.getTime();
        System.out.println(timestamp1);
        // System.out.println("The second one's timestamp is " + timestamp);
    }
}
package cyberbionic.webservices;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        String filePath = "src/cyberbionic/webservices/medicine.xml";
        Document document = db.parse(filePath);

        Element root = document.getDocumentElement();
        String tag = "medicine";
        NodeList list = root.getElementsByTagName(tag);

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println(root.getElementsByTagName("name").item(i).getFirstChild().getTextContent());
            System.out.println(root.getElementsByTagName("pharm").item(i).getFirstChild().getTextContent());
            System.out.println(root.getElementsByTagName("group").item(i).getFirstChild().getTextContent());

            NodeList analogs = root.getElementsByTagName("analogs");
            for (int j =0; j < analogs.getLength(); j++) {
                Node nodeAnalogs = analogs.item(j);
                System.out.println(nodeAnalogs.getTextContent());
            }

            NodeList versions = root.getElementsByTagName("versions");
            for (int k = 0; k <versions.getLength(); k++) {
                Node nodeVersions = versions.item(k);
                System.out.println(nodeVersions.getTextContent());
            }
        }
    }
}

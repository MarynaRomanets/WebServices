package cyberbionic.webservices;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression expression = xPath.compile("//candy//*");
        File xml = new File("C:\\2CyberBionic\\WebServices\\WebServices_JAXB\\Homework" +
                "\\xml_xpath\\src\\cyberbionic\\webservices\\candy.xml");
        InputSource source = new InputSource(new FileInputStream(xml));
        Object result = expression.evaluate(source, XPathConstants.NODESET);
        NodeList list = (NodeList) result;
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println("Node name: " + list.item(i).getNodeName());
            System.out.println("Node value: " + list.item(i).getFirstChild().getNodeValue());
            System.out.println();
        }
    }
}

package cyberbionic.webservices;

import cyberbionic.webservices.entity.Medicine;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MedicineHandler handler = new MedicineHandler();

        File file = new File("src/cyberbionic/webservices/medicine.xml");
        if (file.exists()) {
            parser.parse(file, handler);
            List<Medicine> medicines = handler.getMedicines();
            for (Medicine element:
                 medicines) {
                element.view();
            }
        }
    }
}

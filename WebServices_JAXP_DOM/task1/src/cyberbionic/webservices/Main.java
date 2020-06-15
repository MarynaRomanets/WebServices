package cyberbionic.webservices;

import cyberbionic.webservices.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ParseException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        String filePath = "src/cyberbionic/webservices/medicine.xml";
        Document document = db.parse(filePath);

        List<Medicine> medicines = new ArrayList<>();
        Element root = document.getDocumentElement();
        String tag = "medicine";

        NodeList list = root.getElementsByTagName(tag);
        for (int i = 0; i < list.getLength(); i++) {
            Medicine currentMedicine = new Medicine();
            currentMedicine.setName(root.getElementsByTagName("name").item(i).getFirstChild().getTextContent());
            currentMedicine.setPharm(root.getElementsByTagName("pharm").item(i).getFirstChild().getTextContent());
            currentMedicine.setGroup(root.getElementsByTagName("group").item(i).getFirstChild().getTextContent());

            NodeList analogs = root.getElementsByTagName("analogs");
            for (int j =0; j < analogs.getLength(); j++) {
                Node nodeAnalogs = analogs.item(j);
                Analogs currentAnalog = new Analogs();
                currentAnalog.setAnalog(nodeAnalogs.getTextContent());
                currentMedicine.addAnalogs(currentAnalog);
            }

            NodeList versions = root.getElementsByTagName("versions");
            for (int k = 0; k <versions.getLength(); k++) {
                NodeList versionList = root.getElementsByTagName("version");
                System.out.println("versionList " + versionList.getLength());
                for (int l = 0; l < versionList.getLength(); l++) {
                    //Node nodeVersion = versionList.item(l);
                    Versions currentVersion = new Versions();
                    currentVersion.setConsistention(root.getElementsByTagName("consistention").
                            item(l).getTextContent());

                    //NodeList manufacturer = root.getElementsByTagName("manufacturer");
                    Manufacturer currentManufacturer = new Manufacturer();
                    currentManufacturer.setManufacturer_name(root.getElementsByTagName("manufaturer_name").
                            item(l).getTextContent());

                    Certificate currentCertificate = new Certificate();
                    currentCertificate.setNumber(Integer.parseInt(root.getElementsByTagName("number").
                            item(l).getTextContent()));
                    currentCertificate.setDateStart(new SimpleDateFormat("yyyy-mm-dd").
                            parse(root.getElementsByTagName("date_start").item(l).getTextContent()));
                    currentCertificate.setDateEnd(new SimpleDateFormat("yyyy-mm-dd").
                            parse(root.getElementsByTagName("date_end").item(l).getTextContent()));
                    currentCertificate.setRegistration(root.getElementsByTagName("registration").
                            item(l).getTextContent());
                    currentManufacturer.addCertificate(currentCertificate);


                    MPackage currentPackage = new MPackage();
                    currentPackage.setType(root.getElementsByTagName("type").item(l).getTextContent());
                    currentPackage.setAmount(Integer.parseInt(root.getElementsByTagName("amount").
                            item(l).getTextContent()));
                    currentPackage.setPrice(Double.parseDouble(root.getElementsByTagName("price").
                            item(l).getTextContent()));
                    currentManufacturer.addPackage(currentPackage);

                    Dosage currentDosage = new Dosage();
                    currentDosage.setDose(Double.parseDouble(root.getElementsByTagName("dose").
                            item(l).getTextContent()));
                    currentDosage.setSchedule(Integer.parseInt(root.getElementsByTagName("schedule").
                            item(l).getTextContent()));
                    currentManufacturer.addDosage(currentDosage);

                    currentVersion.addManufacturer(currentManufacturer);
                    currentMedicine.addVersions(currentVersion);
                }
            }
            medicines.add(currentMedicine);
        }

        for (Medicine element:
             medicines) {
            element.view();
        }

    }
}

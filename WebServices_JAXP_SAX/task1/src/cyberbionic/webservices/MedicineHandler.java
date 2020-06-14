package cyberbionic.webservices;

import cyberbionic.webservices.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MedicineHandler extends DefaultHandler {
    private List<Medicine> medicines;
    private Medicine currentMedicine;
    private String currentQName;
    private Analogs currentAnalog;
    private Versions currentVersion;
    private Manufacturer currentManufacturer;
    private Certificate currentCertificate;
    private MPackage currentPackage;
    private Dosage currentDosage;

    public MedicineHandler() {
        medicines = new ArrayList<>();
    }

    public List<Medicine> getMedicines () {
        return medicines;
    }

    @Override
    public void startElement ( String uri, String localName, String qName, Attributes attributes ) throws SAXException {
        currentQName = qName;
    }

    @Override
    public void characters ( char[] ch, int start, int length ) throws SAXException {
        String value = new String(ch, start, length);
        switch (currentQName) {
            case "medicine": currentMedicine = new Medicine(); break;
            case "name": currentMedicine.setName(value); break;
            case "pharm": currentMedicine.setPharm(value); break;
            case "group": currentMedicine.setGroup(value); break;
            case "analogs": currentAnalog = new Analogs(); break;
            case "analog": currentAnalog.setAnalog(value);
                currentMedicine.addAnalogs(currentAnalog); break;
            case "versions":  break;
            case "version": currentVersion = new Versions(); break;
            case "consistention": currentVersion.setConsistention(value); break;
            case "manufacturer": currentManufacturer = new Manufacturer(); break;
            case "manufaturer_name": currentManufacturer.setManufacturer_name(value); break;
            case "certificate": currentCertificate = new Certificate(); break;
            case "number": currentCertificate.setNumber(Integer.parseInt(value)); break;
            case "date_start":
                try {
                    currentCertificate.setDateStart(new SimpleDateFormat("yyyy-mm-dd").parse(value));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "date_end":
                try {
                    currentCertificate.setDateEnd(new SimpleDateFormat("yyyy-mm-dd").parse(value));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "registration": currentCertificate.setRegistration(value);
                currentManufacturer.addCertificate(currentCertificate); break;
            case "package": currentPackage = new MPackage(); break;
            case "type": currentPackage.setType(value); break;
            case "amount": currentPackage.setAmount(Integer.parseInt(value));break;
            case "price": currentPackage.setPrice(Double.parseDouble(value));
                currentManufacturer.addPackage(currentPackage); break;
            case "dosage": currentDosage = new Dosage(); break;
            case "dose": currentDosage.setDose(Double.parseDouble(value)); break;
            case "schedule": currentDosage.setSchedule(Integer.parseInt(value));
                currentManufacturer.addDosage(currentDosage);
                currentVersion.addManufacturer(currentManufacturer);
                currentMedicine.addVersions(currentVersion);
                break;
            default:
        }
    }

    @Override
    public void endElement ( String uri, String localName, String qName ) throws SAXException {
        currentQName="";
        if (qName.equals("medicine")) {
            medicines.add(currentMedicine);
        }
    }
}

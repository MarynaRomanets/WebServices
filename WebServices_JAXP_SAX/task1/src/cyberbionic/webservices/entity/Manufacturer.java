package cyberbionic.webservices.entity;

import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    private String manufacturer_name;
    private List<Certificate> certificates;
    private List<MPackage> packages;
    private List<Dosage> dosages;

    public Manufacturer () {
        certificates = new ArrayList<>();
        packages = new ArrayList<>();
        dosages = new ArrayList<>();
    }

    public void setManufacturer_name ( String manufacturer_name ) {
        this.manufacturer_name = manufacturer_name;
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }

    public void addPackage(MPackage mPackage) {
        packages.add(mPackage);
    }

    public void addDosage(Dosage dosage) {
        dosages.add(dosage);
    }

    public String getManufacturer_name () {
        return manufacturer_name;
    }

    public List<Certificate> getCertificates () {
        return certificates;
    }

    public List<MPackage> getPackages () {
        return packages;
    }

    public List<Dosage> getDosages () {
        return dosages;
    }

    public void view () {
        System.out.println("manufacturer_name: " + manufacturer_name);
        for (Certificate element:
             certificates) {
            element.view();
        }
        for (MPackage element:
             packages) {
            element.view();
        }
        for (Dosage element:
             dosages) {
            element.view();
        }
    }
}

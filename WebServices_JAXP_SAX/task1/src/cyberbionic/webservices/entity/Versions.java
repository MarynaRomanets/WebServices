package cyberbionic.webservices.entity;

import java.util.ArrayList;
import java.util.List;

public class Versions {
    private String consistention;
    private List<Manufacturer> manufacturers;

    public Versions () {
        manufacturers = new ArrayList<>();
    }

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    public void setConsistention ( String consistention ) {
        this.consistention = consistention;
    }

    public String getConsistention () {
        return consistention;
    }

    public List<Manufacturer> getManufacturers () {
        return manufacturers;
    }


    public void view () {
        System.out.println("version: ");
        System.out.println("consistention: " + consistention);
        for (Manufacturer element:
             manufacturers) {
            element.view();
        }
    }
}

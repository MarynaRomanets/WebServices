package cyberbionic.webservices;

import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;
import java.util.List;

public class Candy {

    private String name;
    private List<Structure> structures;
    private List<CandyWrapper> wrappers;

    public Candy () {
    }

    public Candy ( String name, List<Structure> structures, List<CandyWrapper> wrappers ) {
        this.name = name;
        this.structures = structures;
        this.wrappers = wrappers;
    }

    @XmlElement(name = "name")
    public void setName ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    @XmlElement(name = "structure")
    public List<Structure> getStructures () {
        return structures;
    }

    @XmlElement(name = "wrapper")
    public List<CandyWrapper> getWrappers () {
        return wrappers;
    }

    @Override
    public String toString () {
        return "name = " + name + Arrays.deepToString(structures.toArray()) + Arrays.deepToString(wrappers.toArray());
    }
}

package cyberbionic.webservices;

import javax.xml.bind.annotation.XmlElement;

public class Candy {

    private String name;
    private Structure structures;
    private CandyWrapper wrappers;

    public Candy () {
    }

    public Candy ( String name, Structure structures, CandyWrapper wrappers ) {
        this.name = name;
        this.structures = structures;
        this.wrappers = wrappers;
    }

    @XmlElement(name = "structure")
    public void setStructures ( Structure structures ) {
        this.structures = structures;
    }

    @XmlElement(name = "wrapper")
    public void setWrappers ( CandyWrapper wrappers ) {
        this.wrappers = wrappers;
    }

    @XmlElement(name = "name")
    public void setName ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public Structure getStructures () {
        return structures;
    }

    public CandyWrapper getWrappers () {
        return wrappers;
    }

    @Override
    public String toString () {
        return "name = " + name + " structure = " + structures + " wrappers = " + wrappers;
    }
}

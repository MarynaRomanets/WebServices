package cyberbionic.webservices;

import javax.xml.bind.annotation.XmlElement;

public class Structure {
    private double sugar;
    private double chocolate;
    private double nuts;

    public Structure () {
    }

    public double getSugar () {
        return sugar;
    }

    @XmlElement(name = "sugar")
    public void setSugar ( double sugar ) {
        this.sugar = sugar;
    }

    public double getChocolate () {
        return chocolate;
    }

    @XmlElement(name = "chocolate")
    public void setChocolate ( double chocolate ) {
        this.chocolate = chocolate;
    }

    public double getNuts () {
        return nuts;
    }

    @XmlElement(name = "nuts")
    public void setNuts ( double nuts ) {
        this.nuts = nuts;
    }

    @Override
    public String toString () {
        return "sugar = " + sugar + "chocolate = " + chocolate + "nuts = " + nuts;
    }
}

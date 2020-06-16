package cyberbionic.webservices;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "wrapper")
public class CandyWrapper {
    private String type;
    private String color;

    public CandyWrapper ( String type, String color ) {
        this.type = type;
        this.color = color;
    }

    public CandyWrapper () {
    }

    public String getType () {
        return type;
    }

    @XmlElement(name = "type")
    public void setType ( String type ) {
        this.type = type;
    }

    public String getColor () {
        return color;
    }

    @XmlElement(name = "color")
    public void setColor ( String color ) {
        this.color = color;
    }

    @Override
    public String toString () {
        return " type = " + type + " color = " + color;
    }
}

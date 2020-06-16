package cyberbionic.webservices;

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

    public void setType ( String type ) {
        this.type = type;
    }

    public String getColor () {
        return color;
    }

    public void setColor ( String color ) {
        this.color = color;
    }

    @Override
    public String toString () {
        return " type = " + type + " color = " + color;
    }
}

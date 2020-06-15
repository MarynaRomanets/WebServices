package cyberbionic.webservices.entity;

public class Analogs {
    private String analog;

    public Analogs () {
    }

    public String getAnalog () {
        return analog;
    }

    public void setAnalog ( String analog ) {
        this.analog = analog;
    }

    public void view () {
        System.out.println("analog: " + analog);
    }
}

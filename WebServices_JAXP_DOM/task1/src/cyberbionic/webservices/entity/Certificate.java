package cyberbionic.webservices.entity;

import java.util.Date;

public class Certificate {
    private int number;
    private Date dateStart;
    private Date dateEnd;
    private String registration;

    public Certificate () {
    }

    public int getNumber () {
        return number;
    }

    public void setNumber ( int number ) {
        this.number = number;
    }

    public Date getDateStart () {
        return dateStart;
    }

    public void setDateStart ( Date dateStart ) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd () {
        return dateEnd;
    }

    public void setDateEnd ( Date dateEnd ) {
        this.dateEnd = dateEnd;
    }

    public String getRegistration () {
        return registration;
    }

    public void setRegistration ( String registration ) {
        this.registration = registration;
    }

    public void view () {
        System.out.println("number: " + number);
        System.out.println("date_start: " + dateStart);
        System.out.println("date_end: " + dateEnd);
        System.out.println("registration: " + registration);
    }
}

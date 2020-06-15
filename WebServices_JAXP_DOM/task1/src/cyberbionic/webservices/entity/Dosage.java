package cyberbionic.webservices.entity;

public class Dosage {
    private double dose;
    private int schedule;

    public Dosage () {
    }

    public double getDose () {
        return dose;
    }

    public void setDose ( double dose ) {
        this.dose = dose;
    }

    public int getSchedule () {
        return schedule;
    }

    public void setSchedule ( int schedule ) {
        this.schedule = schedule;
    }

    public void view () {
        System.out.println("dose: " + dose);
        System.out.println("schedule: " + schedule);
    }
}

package cyberbionic.webservices.entity;

import java.util.ArrayList;
import java.util.List;

public class Medicine {
    private String name;
    private String pharm;
    private String group;
    private List<Analogs> analogs;
    private List<Versions> versions;

    public Medicine () {
        analogs = new ArrayList<>();
        versions = new ArrayList<>();
    }

    public void addAnalogs(Analogs analog) {
        analogs.add(analog);
    }

    public void addVersions(Versions version) {
        versions.add(version);
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public void setPharm ( String pharm ) {
        this.pharm = pharm;
    }

    public void setGroup ( String group ) {
        this.group = group;
    }

    public String getName () {
        return name;
    }

    public String getPharm () {
        return pharm;
    }

    public String getGroup () {
        return group;
    }

    public List<Analogs> getAnalogs () {
        return analogs;
    }

    public List<Versions> getVersions () {
        return versions;
    }

    public void view() {
        System.out.println("----Medicine: ---");
        System.out.println("name: " + name);
        System.out.println("pharm: " + pharm);
        System.out.println("group: " + group);
        System.out.println("analogs: ");
        for (Analogs element:
                analogs) {
            element.view();
        }
        for (Versions element:
                versions) {
            element.view();
        }
        System.out.println("-----------------");
    }
}

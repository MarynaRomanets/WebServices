package cyberbionic.webservices.entity;

public class MPackage {
    private String type;
    private int amount;
    private double price;

    public MPackage () {
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public int getAmount () {
        return amount;
    }

    public void setAmount ( int amount ) {
        this.amount = amount;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public void view () {
        System.out.println("type: " + type);
        System.out.println("amount: " + amount);
        System.out.println("price: " + price);
    }
}

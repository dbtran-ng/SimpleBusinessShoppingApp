package Model;

public class Discount implements LineItem {
    protected String name;
    protected int ID;
    protected double price;

    public Discount(Item i, double discount) {
        name = i.getName() + " (Discounted)";
        ID = i.getID() + 10000;
        price = i.getPrice() * (1 - discount);

    }

    public Discount(Bundle b, double discount) {
        name = b.getName() + " (Discounted)";
        ID = b.getID() + 10000;
        price = b.getPrice() * (1 - discount);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
    public String toString() {
    	return name;
    }


}

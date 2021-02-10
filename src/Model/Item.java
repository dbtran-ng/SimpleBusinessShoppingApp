package Model;

public class Item implements LineItem{
    private String name;
    private int ID;
    private double price;


    public Item(String name, int ID, double price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }
    
    public String toString() {
    	return name;
    }
    
}

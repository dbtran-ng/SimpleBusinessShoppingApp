package Model;

import java.util.ArrayList;

public class Bundle implements LineItem {
    private String name;
    private int ID;
    private double price;
    public ArrayList<Item> items = new ArrayList<>();

    public Bundle(String name, int ID, double price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }
    public void addItem(Item a){
        items.add(a);
        name +=a.getName()+ "+ ";
        price += a.getPrice();
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

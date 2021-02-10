package Model;

import java.util.ArrayList;

public class Order {
	
	ArrayList<LineItem> itemList;
	public final double tax = 0.09;
	double totalPrice;
	double priceAfterTax;
	
	public Order () {
		this.itemList = new ArrayList<LineItem>();
	}

	public boolean addItem ( LineItem lineItem) {
		if (lineItem == null)
			return false;
		else {
			itemList.add(lineItem);
			return true;
		}	
	}
	public boolean addItem ( Bundle b) {
		if (b == null)
			return false;
		else {
			itemList.add(b);
			return true;
		}	
	}
	public boolean addItem ( Discount d) {
		if (d == null)
			return false;
		else {
			itemList.add(d);
			return true;
		}	
	}
	
	public double getPrice () {
		totalPrice = 0;
		for ( LineItem i : itemList) {
			totalPrice += i.getPrice();

		}
		return totalPrice;
	}
	public double getTotalPrice() {
		return this.totalPrice;
	}
	public double calculateTotal() {
		priceAfterTax = totalPrice * ( 1 + tax);
		return priceAfterTax;

	}

	public int getOrder(int index) {
		return itemList.get(index).getID();
	}
	public ArrayList<LineItem> getOrderList() {
		return itemList;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for ( int i = 0 ; i < itemList.size(); i ++) {
			str.append(itemList.get(i).getName()) ;
			str.append(" - "+ itemList.get(i).getID()+ " -");
			str.append(" $"+ itemList.get(i).getPrice());
			str.append("\n");
		}
		return str.toString();
		
	}
	
	public String toStringforPayFrame() {
		StringBuilder str = new StringBuilder();
		str.append(getPrice());
		return str.toString();
	}

}
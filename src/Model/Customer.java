package Model;

public class Customer {
    public String name;
    public int ID;
    public String address;
    public double balance;
    public double credit_limit;
    public Order newOrder;

    public Customer(int xID, String xName, String xAddress, double xBalance, double xCredit_limit) {
        ID = xID;
        name = xName;
        address = xAddress;
        balance = xBalance;
        credit_limit = xCredit_limit;
    }

    public Customer() {
	}
    
	public String getName() {
		return name;
	}
	public void UpdateBalance(double newBalance) {
        balance += newBalance;
    }

    public double getBalance() {
        return balance;
    }
    
    public String showBalance() {
    	StringBuilder str = new StringBuilder();
    	
    	str.append(balance);
    	return str.toString();
    }

    public void addOrder(Order O) {
    newOrder = O;
    }

    public Order getNewOrder()
    {return newOrder;}
    
    
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("ID: " +ID + "\n") ;
		str.append("NAME: " +name + "\n");
		str.append(address + "\n");
		str.append("BALANCE: $" + balance + "\n");
		str.append("CREDIT LIMIT: $" +credit_limit + "\n");
		str.append("\n");
		
		return str.toString();
	}
}

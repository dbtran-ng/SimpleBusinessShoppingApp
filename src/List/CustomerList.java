package List;

import java.util.ArrayList;
import java.util.List;

import Model.Customer;

public class CustomerList {
	List<Customer> customers = new ArrayList();
	Customer customer1 = new Customer(68965,"Original Joes","901 S First Street", 4384.00,8000.00);
	Customer customer2 = new Customer(1001,"James","116 Capitol Street", 2000.00, 10000.00);

	public List addCustomer() {
		customers.add(customer1);
		customers.add(customer2);
		return customers;
	}
}
package View;

import Model.Customer;
import Model.Order;

import javax.swing.*;

import List.CustomerList;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerView extends JPanel implements ActionListener {
	CustomerList customerList = new CustomerList();
    List<Customer> customers = customerList.addCustomer();
    Customer selectedCustomer;
    JTextArea customerInfo = new JTextArea();
    JScrollPane scroll;
    JComboBox dropdown;

    public CustomerView(List<Customer> customers)
    {
    	setBackground(Color.WHITE);
        this.customers = customers;
        dropdown = new JComboBox();
        dropdown.setBounds(10, 15, 500, 21);
        add(dropdown);

        customerInfo.setBounds(10, 40 , 500, 120);
        customerInfo.setEditable(false);
        add(customerInfo);
        for(Customer customer: customers)
        {
            dropdown.addItem(customer.getName());
        }

        dropdown.setSelectedIndex(0);
        dropdown.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dropdown)
        {
            JComboBox cb = (JComboBox)e.getSource();
            String info = (String)cb.getSelectedItem();
            System.out.println(info);

           for(int i = 0; i < customers.size(); i++)
           {
               if(( customers.get(i)).getName().equals(info))
               {
            	   this.selectedCustomer = customers.get(i);
                   customerInfo.setText(customers.get(i).toString());
               }
           }
        }
    }

}

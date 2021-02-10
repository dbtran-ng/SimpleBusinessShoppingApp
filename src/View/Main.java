package View;

import Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import List.CustomerList;
import List.MenuList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;
	JFrame frmMenu = new JFrame();	
	MenuList menu = new MenuList();
	CustomerList customerList = new CustomerList();
	static Order order = new Order();
	CustomerView customerView;
	ApplicationStateEnum appStateEnum = ApplicationStateEnum.NONE;
	
	private static int selectedIndex = 0;
    private static double price = 0.0;

    public Main() {
    	initialize();
    }
    public void initialize() {
        
        frmMenu.setTitle("Menu");
        frmMenu.setBounds(100, 100, 900, 600);
        frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMenu.getContentPane().setLayout(null);

        // display Menu()
        final List itemList = menu.addMenuList();
        DefaultListModel listModel = new DefaultListModel();
        listModel.addAll(itemList);

        // Customer View
        JPanel customerPanel = new JPanel();
        customerPanel.setBackground(Color.WHITE);
        customerPanel.setBounds(10, 20, 535, 184);
        frmMenu.getContentPane().add(customerPanel);
        final List customers = customerList.addCustomer();
        customerPanel.setLayout(null);
        customerView = new CustomerView(customers);
        customerView.setBounds(10, 5, 515, 169);
        customerPanel.add(customerView);
        customerView.setLayout(null);

        JPanel orderPanel = new JPanel();
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setBounds(555, 20, 324, 495);
        frmMenu.getContentPane().add(orderPanel);
        orderPanel.setLayout(null);
        
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 304, 322);
        orderPanel.add(scrollPane);
        
            JTextArea textArea = new JTextArea();
            scrollPane.setViewportView(textArea);
            textArea.setEditable(false);
            textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // addAction();
                LineItem selectedItem =  (LineItem) itemList.get(selectedIndex);
                System.out.println(selectedItem.getName());
                order.addItem(selectedItem);
                textArea.setText(order.toString());
                textArea.revalidate();
            }
        });
        addButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        addButton.setBounds(10, 382, 138, 39);
        orderPanel.add(addButton);
        


        JButton payButton = new JButton("PAY");
        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                price = order.getPrice();
                System.out.println(price);
                Customer c = customerView.selectedCustomer ;
                c.addOrder(order);
                PayFrame payframe = new PayFrame(c);
                frmMenu.dispose();
                payframe.setVisible(true);
                payframe.setBounds(100, 100, 621, 522);
    			payframe.setSize( 621,522 );
                
            }
        });
        payButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        payButton.setBounds(176, 382, 138, 39);
        orderPanel.add(payButton);
        
        JLabel summaryLabel = new JLabel("Order Summary");
        summaryLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        summaryLabel.setBounds(10, 10, 121, 30);
        orderPanel.add(summaryLabel);       
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 214, 535, 301);
        frmMenu.getContentPane().add(panel);
        panel.setLayout(null);
  
        
        JScrollPane listScroller = new JScrollPane();
        listScroller.setBounds(0, -1, 534, 301);
        panel.add(listScroller);
        JList list = new JList(listModel);
        listScroller.setViewportView(list);
        
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedIndex = list.getSelectedIndex();
                }
            }
        });
    }
    
    public void refreshView(ApplicationStateEnum applicationStateEnum) {
    	if (applicationStateEnum == ApplicationStateEnum.NONE) {
    		// do something
    	}
    	else if (applicationStateEnum == ApplicationStateEnum.NONE) {
    		// do something
    	} 
    }
}

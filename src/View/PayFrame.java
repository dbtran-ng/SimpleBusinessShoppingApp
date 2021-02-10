package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.DoubleValue;
import Model.Customer;
import Model.LineItem;
import Model.Order;

public class PayFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public PayFrame(Customer currentCustomer) {

		setTitle("Payment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		// Create panel 1 to show items on current order and the total
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 10, 586, 450);
		panel1.setLayout(null);

		//add panels to the frame
		getContentPane().add(panel1);
		//getContentPane().add(panel2);

		// panel 1:
		//Creating label to review the order
		JLabel label1 = new JLabel("Review Your Order");
		label1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label1.setBounds(10, 24, 179, 23);
		panel1.add(label1);


		//create string building to append all items on current order
		StringBuilder orderSummary = new StringBuilder();

		//iterate through all items on order and append to a string
		for (LineItem c : currentCustomer.getNewOrder().getOrderList())
		{
			orderSummary.append(c.getName()+"     "+c.getPrice()+"\n");

		}
		orderSummary.append("\n" +
				"\n" +
				"Order Total :   "+ currentCustomer.getNewOrder().getPrice() );


		//create text area to add to panel 2, displaying current customer into
		JTextArea textArea2 = new JTextArea();
		textArea2.setEditable(false);
		textArea2.setBounds(10, 247, 566, 120);
		panel1.add(textArea2);
		//calculate the minimum payment due, by adding total to balance and and subtracting from limit
		//displaying info in text area 2
		double paymentDue = Math.round(currentCustomer.credit_limit-(currentCustomer.getBalance()+currentCustomer.newOrder.getPrice()));
		textArea2.setText("Name: "+currentCustomer.name+"\n"+
				"Balance: "+currentCustomer.balance+"\n"+
				"Credit Limit: " +currentCustomer.credit_limit+"\n"+
				"Minimum Payment Due: "+paymentDue);

		//creating a label to alert customer how much they want to pay
		JLabel label2 = new JLabel("Enter Amount to Pay: ");
		label2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label2.setBounds(10, 370, 230, 30);
		panel1.add(label2);

		//creating a text field for customer to type the desired amount to pay

		JTextField paymentAmount = new JTextField("0.0");
		paymentAmount.setBounds(250,370,200,30);
		panel1.add(paymentAmount);

		//adding the paybutton to process payment
		JButton payButton = new JButton("PAY");
		payButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		payButton.setBounds(10, 410, 138, 39);
		panel1.add(payButton);

		JLabel label3 = new JLabel("Review Information");
		label3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label3.setBounds(10, 214, 179, 23);
		panel1.add(label3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 566, 147);
		panel1.add(scrollPane);
		//create textarea to display all items on current order and the total
		JTextArea textArea1 = new JTextArea();
		scrollPane.setViewportView(textArea1);
		textArea1.setEditable(false);
		//adding the list to text area
		textArea1.setText(orderSummary.toString());
		textArea1.revalidate();

		//adding action listener to process the payment by updating the balance of the customer
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// addAction();
				JFrame frame = new JFrame();
				frame.setTitle("Confirmation");
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setSize(321, 173);


				double paid = Double.valueOf(paymentAmount.getText());
				currentCustomer.UpdateBalance(-1*paid);
				StringBuilder str = new StringBuilder();
				str.append("Amount Paid: " + paid + "\n");
				str.append("New Balance: " + currentCustomer.balance + "\n");
				str.append("~ You have successfully paid for this Order~");

				textArea.setText(str.toString());
				JButton button = new JButton("OK");

				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});

				JPanel panel = new JPanel();
				panel.add(textArea);
				panel.add(button);

				frame.add(panel);
				frame.setVisible(true);
			}
		});

		JFrame frmPay = new JFrame();

		frmPay.setTitle("Payment");
		frmPay.setBounds(100, 100, 900, 600);
		frmPay.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmPay.getContentPane().setLayout(null);
	}
}

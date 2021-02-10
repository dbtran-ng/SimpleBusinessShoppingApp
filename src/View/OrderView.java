package View;

import Model.LineItem;
import Model.Order;

import javax.swing.*;
import java.util.ArrayList;

public class OrderView extends JPanel {
    JTextArea orderInfo = new JTextArea();
    Order order;
    JTextArea orderTotal = new JTextArea();

    public OrderView(Order order)
    {
        this.order = order;
        add(orderInfo);
        add(orderTotal);

        orderInfo.setText(order.toString());
        String total = String.valueOf(order.getPrice());
        orderTotal.setText(total);

    }
}

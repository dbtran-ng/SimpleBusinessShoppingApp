package List;

import java.util.ArrayList;
import java.util.List;

import Model.Bundle;
import Model.Item;
import Model.LineItem;
import Model.Discount;
public class
MenuList {
	List<LineItem> itemList = new ArrayList();

	LineItem item1 = new Item("1000 Stories Zinfandel",1000, 180.00);
    LineItem item2 = new Item("A to Z Wineworks Chardonnay",1001, 160.00);
    LineItem item3 = new Item("Aiden Napa Valley Chardonnay",1002, 190.00);
    LineItem item4 = new Item("Babcock Santa Maria Chardonnay",1003, 210.00);
    LineItem item5 = new Item("Cakebread Napa Valley Chardonnay",1004, 240.00);
    LineItem item6 = new Item("District 7 Chardonnay",1005, 140.00);
    LineItem item7 = new Item("1000 Stories Cabernet",1000, 20);
    LineItem item8 = new Item("A to Z Wineworks Cabernet",1001, 50);
    LineItem item9 = new Item("Aiden Napa Valley Cabernet",1000, 20);
    LineItem item10 = new Item("Babcock Santa Maria Cabernet",1001, 50);
    LineItem item11 = new Item("Cakebread Napa Valley Cabernet",1000, 20);
    LineItem item12 = new Item("District 7 Cabernet",1001, 50);
    Bundle item13 = new Bundle("Bundle Of: ",90001,0);
    Bundle item14 = new Bundle("Bundle Of: ",90002, 0);
    LineItem item15 = new Item("Cakebread Napa Valley Cabernet",1000, 20);
    LineItem item16 = new Item("Cakebread Napa Valley Cabernet",1000, 20);
    LineItem item17 = new Item("Cakebread Napa Valley Cabernet",1000, 20);

    public List addMenuList() {
		item13.addItem((Item)item1);
		item13.addItem((Item)item7);
		item14.addItem((Item)item2);
		item14.addItem((Item)item8);
		Discount item15 = new Discount((Item)item3,0.15);
		Discount item16 = new Discount((item14),0.20);
		itemList.add(item1);
	    itemList.add(item2);
	    itemList.add(item3);
	    itemList.add(item4);
	    itemList.add(item5);
	    itemList.add(item6);
	    itemList.add(item7);
	    itemList.add(item8);
	    itemList.add(item9);
	    itemList.add(item10);
	    itemList.add(item11);
	    itemList.add(item12);
	    itemList.add(item13);
	    itemList.add(item14);
	    itemList.add(item15);
	    itemList.add(item16);
	    itemList.add(item17);
		return itemList;
	  
	}

}

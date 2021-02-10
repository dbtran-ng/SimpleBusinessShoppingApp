package Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Item i1 = new Item("item1",15,50);
		Bundle b = new Bundle("b1",200,60);
		
		Order o = new Order();
		o.addItem(i1);
		o.addItem(b);

		assertEquals(15,o.getOrder(0));
		assertEquals(200,o.getOrder(1));
	
	}
}

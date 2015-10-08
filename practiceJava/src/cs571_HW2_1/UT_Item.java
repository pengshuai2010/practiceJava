/**
 * 
 */
package cs571_HW2_1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author speng
 * created on Oct 7, 2015
 */
public class UT_Item {


	/**
	 * Test method for {@link cs571_HW2_1.Item#getItemTotal()}.
	 */
	@Test
	public void testGetItemTotal() {
		Item item = new Item();
		double price = 1.6;
		double quantity = 2;
		item.setOrigUnitPrice(price);
		item.setQuantity(quantity);
		double delta = 1e-5;
		assertEquals(price*quantity, item.getItemTotal(), delta);
	}

}

/**
 * 
 */
package cs571_HW2_5;

import static org.junit.Assert.*;
import org.junit.Test;

import cs571_HW2_5.Item;

/**
 * @author speng
 * created on Oct 7, 2015
 */
public class UT_Item {


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
	
	@Test
	public void testGetItemTotalWithSpecialDiscounts() {
		Item.addToSpecialDiscounts("carrot");
		double price = 1.6;
		double quantity = 2;
		String title = "carrot";
		Item item = new Item(title, price, quantity);
		double delta = 1e-5;
		assertEquals(price*(1 + 0.5*(quantity - 1)), item.getItemTotal(), delta);
	}
	
	@Test
	public void testAddToSpecialDiscouts() {
		Item.addToSpecialDiscounts("green pepper");
		assertTrue(Item.isApplicableToSpecialDiscounts("green pepper"));
	}
	@Test
	public void testRemoveFromSpecialDiscouts() {
		Item.addToSpecialDiscounts("cabage");
		assertTrue(Item.isApplicableToSpecialDiscounts("cabage"));
		Item.removeFromSpecialDiscounts("cabage");
		assertFalse(Item.isApplicableToSpecialDiscounts("cabage"));
	}
	@Test
	public void testSetOrigUnitPrice() {
		Item item = new Item();
		double price = -1.6;
		try {
			item.setOrigUnitPrice(price);
		    fail( "My method didn't throw when I expected it to" );
		} catch (IllegalArgumentException expectedException) {
		}
	}
}

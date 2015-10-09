/**
 * 
 */
package cs571_HW2_5;

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
	
	@Test
	public void testGetItemTotalWithSpecialDiscounts() {
		Item.addToSpecialDiscouts("carrot");
		double price = 1.6;
		double quantity = 2;
		String title = "carrot";
		Item item = new Item(title, price, quantity);
		double delta = 1e-5;
		assertEquals(price*(1 + 0.5*(quantity - 1)), item.getItemTotal(), delta);
	}
	
	@Test
	public void testAddToSpecialDiscouts() {
		Item.addToSpecialDiscouts("green pepper");
		assertTrue(Item.isApplicableToSpecialDiscouts("green pepper"));
	}
	@Test
	public void testRemoveFromSpecialDiscouts() {
		Item.addToSpecialDiscouts("cabage");
		assertTrue(Item.isApplicableToSpecialDiscouts("cabage"));
		Item.removeFromSpecialDiscouts("cabage");
		assertFalse(Item.isApplicableToSpecialDiscouts("cabage"));
	}

}

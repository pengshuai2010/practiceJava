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
public class UT_Sale {
	
	/**
	 * Test method for {@link cs571_HW2_1.Sale#getDiscount()}.
	 */
	@Test
	public void testGetDiscount() {
		Sale sale = new Sale();
		sale.addItem(new Item("apple", 1.6, 2));
		sale.addItem(new Item("orange", 0.8, 2));
		assertEquals((1.6*2 + 0.8*2)*sale.getDiscountRate(), sale.getDiscount(), 1e-5);
	}

	/**
	 * Test method for {@link cs571_HW2_1.Sale#getSubTotal()}.
	 */
	@Test
	public void testGetSubTotal() {
		Sale sale = new Sale();
		sale.addItem(new Item("apple", 1.6, 2));
		sale.addItem(new Item("orange", 0.8, 2));
		assertEquals(1.6*2 + 0.8*2, sale.getSubTotal(), 1e-5);
	}

	/**
	 * Test method for {@link cs571_HW2_1.Sale#getDiscountedSubTotal()}.
	 */
	@Test
	public void testGetDiscountedSubTotal() {
		Sale sale = new Sale();
		sale.addItem(new Item("apple", 1.6, 2));
		sale.addItem(new Item("orange", 0.8, 2));
		assertEquals((1.6*2 + 0.8*2)*(1- sale.getDiscountRate()), sale.getDiscountedSubTotal(), 1e-5);
	}

}

/**
 * 
 */
package cs571_HW2_4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author speng
 * created on Oct 7, 2015
 */
public class UT_Sale {
	
	@Test
	public void testGetDiscountRate() {
		
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new Customer(), day);
			assertEquals(0.05, 
					sale.getDiscountRate(), 1e-5);
		}
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new PrefferedCustomer(), day);
			assertEquals(0.08, 
					sale.getDiscountRate(), 1e-5);
		}
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new SeniorCustomer(), day);
			if(day == Day.TUESDAY) {
				assertEquals(0.08, 
						sale.getDiscountRate(), 1e-5);
			} else {
				assertEquals(0.05, 
						sale.getDiscountRate(), 1e-5);
			}
		}
	}
	
	/**
	 * Test method for {@link cs571_HW2_1.Sale#getDiscount()}.
	 */
	@Test
	public void testGetDiscount() {

		for(Day day: Day.values()) {
			Sale sale = new Sale(new Customer(), day);
			sale.addItem(new Item("apple", 1.6, 2));
			sale.addItem(new Item("orange", 0.8, 2));
			assertEquals((1.6*2 + 0.8*2)*0.05, 
					sale.getDiscount(), 1e-5);
		}
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new PrefferedCustomer(), day);
			sale.addItem(new Item("apple", 1.6, 2));
			sale.addItem(new Item("orange", 0.8, 2));
			assertEquals((1.6*2 + 0.8*2)*0.08, 
					sale.getDiscount(), 1e-5);
		}
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new SeniorCustomer(), day);
			sale.addItem(new Item("apple", 1.6, 2));
			sale.addItem(new Item("orange", 0.8, 2));
			if(day == Day.TUESDAY) {
				assertEquals((1.6*2 + 0.8*2)*0.08, 
						sale.getDiscount(), 1e-5);
			} else {
				assertEquals((1.6*2 + 0.8*2)*0.05, 
						sale.getDiscount(), 1e-5);
			}
		}
	}

	/**
	 * Test method for {@link cs571_HW2_1.Sale#getSubTotal()}.
	 */
	@Test
	public void testGetSubTotal() {
		Sale sale = new Sale(new Customer(), Day.FRIDAY);
		sale.addItem(new Item("apple", 1.6, 2));
		sale.addItem(new Item("orange", 0.8, 2));
		assertEquals(1.6*2 + 0.8*2, sale.getSubTotal(), 1e-5);
	}

	/**
	 * Test method for {@link cs571_HW2_1.Sale#getDiscountedSubTotal()}.
	 */
	@Test
	public void testGetDiscountedSubTotal() {
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new Customer(), day);
			sale.addItem(new Item("apple", 1.6, 2));
			sale.addItem(new Item("orange", 0.8, 2));
			assertEquals((1.6*2 + 0.8*2)*(1 - 0.05), 
					sale.getDiscountedSubTotal(), 1e-5);
		}
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new PrefferedCustomer(), day);
			sale.addItem(new Item("apple", 1.6, 2));
			sale.addItem(new Item("orange", 0.8, 2));
			assertEquals((1.6*2 + 0.8*2)*( 1 - 0.08), 
					sale.getDiscountedSubTotal(), 1e-5);
		}
		
		for(Day day: Day.values()) {
			Sale sale = new Sale(new SeniorCustomer(), day);
			sale.addItem(new Item("apple", 1.6, 2));
			sale.addItem(new Item("orange", 0.8, 2));
			if(day == Day.TUESDAY) {
				assertEquals((1.6*2 + 0.8*2)*(1 - 0.08), 
						sale.getDiscountedSubTotal(), 1e-5);
			} else {
				assertEquals((1.6*2 + 0.8*2)*(1 - 0.05), 
						sale.getDiscountedSubTotal(), 1e-5);
			}
		}
	}

}

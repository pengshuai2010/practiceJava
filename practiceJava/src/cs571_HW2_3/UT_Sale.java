/**
 * 
 */
package cs571_HW2_3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author speng
 * created on Oct 7, 2015
 */
public class UT_Sale {
	
	@Test
	public void testGetDiscountRate() {
		Sale sale = new Sale();
		
		for(Day day: Day.values()) {
			assertEquals(Sale.getDISCOUNT_RATE_DEFAULT(), 
					sale.getDiscountRate(Customer.DEFAULT, day), 1e-5);
		}
		
		for(Day day: Day.values()) {
			assertEquals(Sale.getDISCOUNT_RATE_PREFERED(), 
					sale.getDiscountRate(Customer.PREFFERED, day), 1e-5);
		}
		
		for(Day day: Day.values()) {
			if(day == Day.TUESDAY) {
				assertEquals(Sale.getDISCOUNT_RATE_SINIOR(), 
						sale.getDiscountRate(Customer.SENIOR, day), 1e-5);
			} else {
				assertEquals(Sale.getDISCOUNT_RATE_DEFAULT(), 
						sale.getDiscountRate(Customer.SENIOR, day), 1e-5);
			}
		}
	}
	
	/**
	 * Test method for {@link cs571_HW2_1.Sale#getDiscount()}.
	 */
	@Test
	public void testGetDiscount() {
		Sale sale = new Sale();
		sale.addItem(new Item("apple", 1.6, 2));
		sale.addItem(new Item("orange", 0.8, 2));
		for(Day day: Day.values()) {
			assertEquals((1.6*2 + 0.8*2)*Sale.getDISCOUNT_RATE_DEFAULT(), 
					sale.getDiscount(Customer.DEFAULT, day), 1e-5);
		}
		
		for(Day day: Day.values()) {
			assertEquals((1.6*2 + 0.8*2)*Sale.getDISCOUNT_RATE_PREFERED(), 
					sale.getDiscount(Customer.PREFFERED, day), 1e-5);
		}
		
		for(Day day: Day.values()) {
			if(day == Day.TUESDAY) {
				assertEquals((1.6*2 + 0.8*2)*Sale.getDISCOUNT_RATE_SINIOR(), 
						sale.getDiscount(Customer.SENIOR, day), 1e-5);
			} else {
				assertEquals((1.6*2 + 0.8*2)*Sale.getDISCOUNT_RATE_DEFAULT(), 
						sale.getDiscount(Customer.SENIOR, day), 1e-5);
			}
		}
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
		
		for(Day day: Day.values()) {
			assertEquals((1.6*2 + 0.8*2)*(1 - Sale.getDISCOUNT_RATE_DEFAULT()), 
					sale.getDiscountedSubTotal(Customer.DEFAULT, day), 1e-5);
		}
		
		for(Day day: Day.values()) {
			assertEquals((1.6*2 + 0.8*2)*( 1 - Sale.getDISCOUNT_RATE_PREFERED()), 
					sale.getDiscountedSubTotal(Customer.PREFFERED, day), 1e-5);
		}
		
		for(Day day: Day.values()) {
			if(day == Day.TUESDAY) {
				assertEquals((1.6*2 + 0.8*2)*(1 - Sale.getDISCOUNT_RATE_SINIOR()), 
						sale.getDiscountedSubTotal(Customer.SENIOR, day), 1e-5);
			} else {
				assertEquals((1.6*2 + 0.8*2)*(1 - Sale.getDISCOUNT_RATE_DEFAULT()), 
						sale.getDiscountedSubTotal(Customer.SENIOR, day), 1e-5);
			}
		}
	}

}

/**
 * 
 */
package cs571_HW2_4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author shuaipeng
 *
 */
public class UT_Customer {

	/**
	 * Test method for {@link cs571_HW2_4.Customer#setDISCOUNT_RATE(double)}.
	 */
	@Test
	public void testSetDISCOUNT_RATE() {
		Customer customer = new Customer();
		try {
			customer.setDISCOUNT_RATE(-1);
		    fail( "My method didn't throw when I expected it to" );
		} catch (IllegalArgumentException expectedException) {
		}
		try {
			customer.setDISCOUNT_RATE(1);
		    fail( "My method didn't throw when I expected it to" );
		} catch (IllegalArgumentException expectedException) {
		}
	}

}

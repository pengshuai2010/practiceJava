/**
 * 
 */
package cs571_HW2_4;

import static org.junit.Assert.*;

import org.junit.Test;

import cs571_HW2_4.Customer;

/**
 * @author shuaipeng
 *
 */
public class UT_PrefferedCustom {

	@Test
	public void testSetDISCOUNT_RATE() {
		Customer customer = new PrefferedCustomer();
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

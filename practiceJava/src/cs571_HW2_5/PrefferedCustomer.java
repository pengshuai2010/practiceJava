/**
 * 
 */
package cs571_HW2_5;

/**
 * @author speng
 * created on Oct 8, 2015
 */
public class PrefferedCustomer extends Customer {
	private static double DISCOUNT_RATE = 0.08;
	public double getDISCOUNT_RATE(Day day) {
		return DISCOUNT_RATE;
	}

	public void setDISCOUNT_RATE(double dISCOUNT_RATE) {
		if(dISCOUNT_RATE < 0 || dISCOUNT_RATE >= 1) {
			throw new IllegalArgumentException("DISCOUNT_RATE should be greater or equal 0 and  less than 1");
		}
		DISCOUNT_RATE = dISCOUNT_RATE;
	}
}

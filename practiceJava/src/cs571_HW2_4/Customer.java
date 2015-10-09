/**
 * 
 */
package cs571_HW2_4;

/**
 * @author speng
 * created on Oct 7, 2015
 */
public class Customer {
	private static double DISCOUNT_RATE = 0.05;

	public double getDISCOUNT_RATE(Day day) {
		return DISCOUNT_RATE;
	}

	public void setDISCOUNT_RATE(double dISCOUNT_RATE) {
		DISCOUNT_RATE = dISCOUNT_RATE;
	}
}

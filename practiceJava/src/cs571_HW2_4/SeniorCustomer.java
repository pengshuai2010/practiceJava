/**
 * 
 */
package cs571_HW2_4;

/**
 * @author speng
 * created on Oct 8, 2015
 */
public class SeniorCustomer extends Customer {
	private static double DISCOUNT_RATE = 0.08;
	public double getDISCOUNT_RATE(Day day) {
		if(day == Day.TUESDAY)
			return DISCOUNT_RATE;
		else
			return super.getDISCOUNT_RATE(day);
	}

	public void setDISCOUNT_RATE(double dISCOUNT_RATE) {
		DISCOUNT_RATE = dISCOUNT_RATE;
	}
}

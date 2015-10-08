package cs571_HW2_3;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private static double DISCOUNT_RATE_DEFAULT = 0.05;
	private static double DISCOUNT_RATE_SINIOR = 0.10;
	private static double DISCOUNT_RATE_PREFERED = 0.10;

	public static double getDISCOUNT_RATE_DEFAULT() {
		return DISCOUNT_RATE_DEFAULT;
	}

	public static void setDISCOUNT_RATE_NORMAL(double dISCOUNT_RATE_NORMAL) {
		DISCOUNT_RATE_DEFAULT = dISCOUNT_RATE_NORMAL;
	}

	public static double getDISCOUNT_RATE_SINIOR() {
		return DISCOUNT_RATE_SINIOR;
	}

	public static void setDISCOUNT_RATE_SINIOR(double dISCOUNT_RATE_SINIOR) {
		DISCOUNT_RATE_SINIOR = dISCOUNT_RATE_SINIOR;
	}

	public static double getDISCOUNT_RATE_PREFERED() {
		return DISCOUNT_RATE_PREFERED;
	}

	public static void setDISCOUNT_RATE_PREFERED(double dISCOUNT_RATE_PREFERED) {
		DISCOUNT_RATE_PREFERED = dISCOUNT_RATE_PREFERED;
	}

	private List<Item> itemList = new ArrayList<Item>();

	public void addItem(Item item) {
		itemList.add(item);
	}

	public double getDiscountRate(Customer customer, Day day){
		switch(customer) {
		case SENIOR:
			if(day == Day.TUESDAY)
				return DISCOUNT_RATE_SINIOR;
			else
				return DISCOUNT_RATE_DEFAULT;
		case PREFFERED:
			return DISCOUNT_RATE_PREFERED;
		default:
			return DISCOUNT_RATE_DEFAULT;
		}
	}
	
	public double getDiscount(Customer customer, Day day){
		return getSubTotal()*getDiscountRate(customer, day);
	}
	
	public double getSubTotal() {
		double subTotal = 0.0;
		for (Item item: itemList) {
				subTotal += item.getItemTotal();
		}	
		return subTotal;
	}
		
	public double getDiscountedSubTotal(Customer customer, Day day) {
		return getSubTotal() - getDiscount(customer, day);
	}
}

package cs571_HW2_2;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private static double DISCOUNT_RATE_NORMAL = 0.05;
	private static double DISCOUNT_RATE_SINIOR = 0.10;
	private static double DISCOUNT_RATE_PREFERED = 0.10;

	private List<Item> itemList = new ArrayList<Item>();

	public void addItem(Item item) {
		itemList.add(item);
	}

	public double getDiscountRate(Customer customer){
		switch(customer) {
		case SENIOR:
			return DISCOUNT_RATE_SINIOR;
		case PREFFERED:
			return DISCOUNT_RATE_PREFERED;
		default:
			return DISCOUNT_RATE_NORMAL;
		}
			
	}	
	
	public double getDiscount(Customer customer){
		return getSubTotal()*getDiscountRate(customer);
	}
	
	public double getSubTotal() {
		double subTotal = 0.0;
		for (Item item: itemList) {
				subTotal += item.getItemTotal();
		}	
		return subTotal;
	}
		
	public double getDiscountedSubTotal(Customer customer) {
		return getSubTotal() - getDiscount(customer);
	}
}

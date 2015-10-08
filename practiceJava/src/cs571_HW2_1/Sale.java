package cs571_HW2_1;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private static double DISCOUNT_RATE = 0.05;

	private List<Item> itemList = new ArrayList<Item>();

	public void addItem(Item item) {
		itemList.add(item);
	}

	public double getDiscountRate(){
			return DISCOUNT_RATE;
	}	
	
	public double getDiscount(){
		return getSubTotal()*getDiscountRate();
	}
	
	public double getSubTotal() {
		double subTotal = 0.0;
		for (Item item: itemList) {
				subTotal += item.getItemTotal();
		}	
		return subTotal;
	}
		
	public double getDiscountedSubTotal() {
		return getSubTotal() - getDiscount();
	}
}

package cs571_HW2_5;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private Customer customer = null;
	private Day day = null;
	
	/**
	 * @param customer
	 * @param day
	 */
	public Sale(Customer customer, Day day) {
		super();
		this.customer = customer;
		this.day = day;
	}

	private List<Item> itemList = new ArrayList<Item>();

	public void addItem(Item item) {
		itemList.add(item);
	}

	public double getDiscountRate(){
		return customer.getDISCOUNT_RATE(day);
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

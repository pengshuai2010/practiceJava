package cs571_HW2_5;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private String title;
	private double origUnitPrice;
	private double quantity;
	static private Set<String> specialDiscounts = new HashSet<String>();
	public Item() {
	}
	
	static public void addToSpecialDiscouts(String title) {
		specialDiscounts.add(title);
	}
	
	static boolean removeFromSpecialDiscouts(String title) {
		return specialDiscounts.remove(title);
	}
	
	static boolean isApplicableToSpecialDiscouts(String title) {
		return specialDiscounts.contains(title);
	}
	
	public Item(String title, double origUnitPrice, double quantity) {
		this.setTitle(title);
		this.setOrigUnitPrice(origUnitPrice);
		this.setQuantity(quantity);
	}
	
	public double getItemTotal() {
		if(specialDiscounts.contains(title) && getQuantity() > 1) {
			return getOrigUnitPrice()*(1 + 0.5*(getQuantity() - 1));
		}
		return this.getOrigUnitPrice()*this.getQuantity();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getOrigUnitPrice() {
		return origUnitPrice;
	}
	public void setOrigUnitPrice(double origUnitPrice) {
		this.origUnitPrice = origUnitPrice;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}

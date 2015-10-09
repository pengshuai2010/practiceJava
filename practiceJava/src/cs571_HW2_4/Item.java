package cs571_HW2_4;

public class Item {
	private String title;
	private double origUnitPrice;
	private double quantity;
	
	public Item() {
	}
	
	public Item(String title, double origUnitPrice, double quantity) {
		this.setTitle(title);
		this.setOrigUnitPrice(origUnitPrice);
		this.setQuantity(quantity);
	}
	
	public double getItemTotal() {
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

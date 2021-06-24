package jp.co.aforce.beans;

public class ShoppingSpeaker implements java.io.Serializable{
	private int id;
	private String itemName;
	private int price;
	private int categoryId;
	
	public int getId() {
		return id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId=categoryId;
	}


}

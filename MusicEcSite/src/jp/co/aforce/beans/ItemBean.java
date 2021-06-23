package jp.co.aforce.beans;

import java.io.Serializable;

public class ItemBean implements Serializable{
	
	private int id;
	private String itemName;
	private int price;
	private int categoryId;
	private String completeMsg;
	private String errorMsg;

	
	public ItemBean() {
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCompleteMsg() {
		return completeMsg;
	}
	
	public void setCompleteMsg(String completeMsg) {
		this.completeMsg = completeMsg;
	}
	
	public String errorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}

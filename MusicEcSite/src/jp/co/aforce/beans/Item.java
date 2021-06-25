package jp.co.aforce.beans;

public class Item implements java.io.Serializable{
	private ShoppingHead shoppingHead;
	private int count;
	private Object shoppingProduct;
	
	public ShoppingHead getShoppingHead(){
		return shoppingHead;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setShoppingHead(ShoppingHead shoppingHead) {
		this.shoppingHead=shoppingHead;
	}
	
	public void setCount(int count) {
		this.count=count;
	}

	public void setShoppingProduct(ShoppingProduct lineProduct) {
		// TODO 自動生成されたメソッド・スタブ
		this.shoppingProduct=shoppingProduct;
	}

}

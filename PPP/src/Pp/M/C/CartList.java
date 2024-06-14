package Pp.M.C;

import Pp.M.I.ItemList;

public class CartList extends ItemList{
	private int quantity;
	public CartList(int productId,String model,String manufacturer,String operatingSystem,int price) {
		super(productId, model, manufacturer, operatingSystem, price);
        this.quantity = 0;
	}
    public int setQuantity(int a) {
		return quantity = a;
	}
	@Override
	public String toString() {
		return productId + ", " + model + ", " + manufacturer + ", " + operatingSystem + ", " + quantity +"대, " + price + "원";
	}
}
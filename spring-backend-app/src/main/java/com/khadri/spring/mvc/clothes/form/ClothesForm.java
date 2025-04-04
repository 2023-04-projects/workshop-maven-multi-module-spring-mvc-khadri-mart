package com.khadri.spring.mvc.clothes.form;

public class ClothesForm {
	private String itemName;
	private int itemQty;
	private Double itemPrice;

	public ClothesForm() {
		super();
	}

	public ClothesForm(String itemName, int itemQty, Double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemQty() {
		return itemQty;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

}

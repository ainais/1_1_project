package com.java.domain;

public class ShopBasketVO {

	private String userID;
	private String productID;
	private String productPrice;
	private String productImageSrc;
	private String basketRegDate;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImageSrc() {
		return productImageSrc;
	}
	public void setProductImageSrc(String productImageSrc) {
		this.productImageSrc = productImageSrc;
	}
	public String getBasketRegDate() {
		return basketRegDate;
	}
	public void setBasketRegDate(String basketRegDate) {
		this.basketRegDate = basketRegDate;
	}
	
	
}

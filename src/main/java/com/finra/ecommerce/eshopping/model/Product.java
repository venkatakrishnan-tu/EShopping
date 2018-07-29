package com.finra.ecommerce.eshopping.model;

import java.util.Date;

/*
 * @author Poornima
 */
public class Product {
	private int productId;
	private String title;
	private String price;
	private String description;
	private int quantity;
	private Date created;
	
	public Product(){
		super();
	}
	
	public Product(int productId, String title, String price, String description, int quantity, Date created) {
		super();
		this.productId = productId;
		this.title = title;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.created = created;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

}

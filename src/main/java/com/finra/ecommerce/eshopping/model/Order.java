package com.finra.ecommerce.eshopping.model;
/*
 * @author Poornima
 */
public class Order {

	private int id;
	private String name;
	private String address;
	private String city;
	private String zip;
	private String status;
	private String comment;
	private double totalPrice;
	private int userId;
	private int productId;
    private String creditCardNo;
	private int quantity;
	
	public Order(){
		super();
	}
	
	public Order(int id, String name, String address, String city, String zip, String status, String comment,
			double totalPrice, int userId, int productId, String creditCardNo, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.status = status;
		this.comment = comment;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.productId = productId;
		this.creditCardNo = creditCardNo;
		this.quantity = quantity;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

package com.finra.ecommerce.eshopping.model;

import java.util.Date;

/*
 * @author Poornima
 */
public class User {
	private int userId;
    private String name;
    private String email;
    private String password;
    private Date created;

    public User(){
    	super();
    }
    
    public User(int userId, String name, String email) {
		this.userId = userId;
		this.name = name;
		this.email = email;
	}
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
    
}

package com.finra.ecommerce.eshopping.service;

import com.finra.ecommerce.eshopping.model.User;

/**
 * 
 * @author poornima
 *
 */
public interface UserService {
	public User getUser(int userId);
	public int updateUser(User user);
}

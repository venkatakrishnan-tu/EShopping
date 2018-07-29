package com.finra.ecommerce.eshopping.dao;

import java.util.List;

import com.finra.ecommerce.eshopping.model.User;;

/*
 * @author Poornima
 */
public interface UserDao {
	User findById(long id);	
	List<User> findAll();
	int updateUser(User user);
}
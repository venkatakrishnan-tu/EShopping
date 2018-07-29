package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.dao.UserDao;
import com.finra.ecommerce.eshopping.model.Product;
import com.finra.ecommerce.eshopping.model.User;
/**
 * 
 * @author poornima
 *
 */
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDAO;
	
  

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return userDAO.findById(userId);
	}


	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

 
}

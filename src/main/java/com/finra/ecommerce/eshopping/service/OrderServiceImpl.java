package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.dao.OrderDao;
import com.finra.ecommerce.eshopping.model.Order;
/**
 * 
 * @author poornima
 *
 */
@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDAO;
	
 
	@Override
	public Order getOrder(int orderId) {
		return orderDAO.findById(orderId);
	}
}

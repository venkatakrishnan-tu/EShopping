package com.finra.ecommerce.eshopping.dao;

import java.util.List;

import com.finra.ecommerce.eshopping.model.Order;

/*
 * @author Poornima
 */
public interface OrderDao {
	public Order findById(int id);
	public void processOrder(int id, String status);
	public List<Order> findAllOrders();
	public void persistOrder(Order order);
}
package com.finra.ecommerce.eshopping.dao;

import java.util.List;

import com.finra.ecommerce.eshopping.model.Order;

/*
 * @author Poornima
 */
public interface OrderDao {
	Order findById(int id);
	Order processOrder(int id, String status);
	List<Order> findAllOrders();
}
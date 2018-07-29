package com.finra.ecommerce.eshopping.service;

import com.finra.ecommerce.eshopping.model.Order;

/**
 * 
 * @author poornima
 *
 */
public interface OrderService {
	public Order getProduct(int orderId);
	public void persistOrder(Order order);
}

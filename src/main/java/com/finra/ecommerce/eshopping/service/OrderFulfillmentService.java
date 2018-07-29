package com.finra.ecommerce.eshopping.service;

import com.finra.ecommerce.eshopping.model.Order;
/**
 * 
 * @author poornima
 *
 */
public interface OrderFulfillmentService {
    boolean placeOrder(Order order);
}
package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.dao.OrderDao;
import com.finra.ecommerce.eshopping.dao.ProductDao;
import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.model.OrderStatus;
import com.finra.ecommerce.eshopping.model.Product;

/*
 * @author Poornima
 */
@Component
public class ShipmentServiceImpl implements ShipmentService{
	
	@Autowired
	OrderDao orderDAO;
	
	@Autowired
	ProductDao productDAO;
	
	@Override
	public void shipOrder(Order order){
		orderDAO.processOrder(order.getOrderId(), OrderStatus.SUCCESS.getStatus());
		Product p = productDAO.findById(order.getProductId());
		if (p != null){
			productDAO.update(p, order.getQuantity());
		}	
    }
}
 
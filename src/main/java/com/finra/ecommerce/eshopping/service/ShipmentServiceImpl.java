package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.dao.OrderDao;
import com.finra.ecommerce.eshopping.dao.ProductDao;
import com.finra.ecommerce.eshopping.dao.UserDao;
import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.model.OrderStatus;
import com.finra.ecommerce.eshopping.model.Product;
import com.finra.ecommerce.eshopping.model.User;

/*
 * @author Poornima
 */
@Component
public class ShipmentServiceImpl implements ShipmentService{
	
	@Autowired
	OrderDao orderDAO;
	
	@Autowired
	ProductDao productDAO;
	
	@Autowired
	UserDao userDAO;
	
	@Autowired
	EmailNotificationService emailNotificationService;
	
	@Override
	public void shipOrder(Order order){
		orderDAO.processOrder(order.getOrderId(), OrderStatus.SUCCESS.getStatus());
		Product p = productDAO.findById(order.getProductId());
		if (p != null){
			productDAO.update(p, order.getQuantity());
			User user = userDAO.findById(order.getUserId());
			if(user!=null){
				emailNotificationService.sendEmail(user.getEmail());	
			}
		}
    }
}
 
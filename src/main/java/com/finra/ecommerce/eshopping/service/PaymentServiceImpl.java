package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.dao.OrderDao;
import com.finra.ecommerce.eshopping.dao.ProductDao;

/*
 * @author Poornima
 */
@Component
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	OrderDao orderDAO;
	
	@Autowired
	ProductDao productDAO;
	
	@Override
	public boolean chargePayment(String creditCardNumber, double amount) {
		return true;
	}
}

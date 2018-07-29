package com.finra.ecommerce.eshopping.service;


public interface PaymentService {
	boolean chargePayment(String creditCardNumber, double amount);
	void failedOrder(int orderId);
}

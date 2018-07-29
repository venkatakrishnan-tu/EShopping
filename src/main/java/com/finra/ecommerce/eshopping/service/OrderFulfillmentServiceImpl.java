package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.model.Product;

/**
 * 
 * @author poornima
 *
 */
@Component
public class OrderFulfillmentServiceImpl implements OrderFulfillmentService{

	@Autowired
	InventoryService inventoryService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	ShipmentService shipmentService;

	public boolean placeOrder(Order order){
		boolean orderFulfilled=false;

		if(inventoryService.checkInventory(Integer.toString(order.getProductId()), order.getQuantity())){
			if(isValidCreditCardNum(order.getCreditCardNo())){
				paymentService.chargePayment(order.getCreditCardNo(), order.getTotalPrice());
				shipmentService.shipOrder(order);
				orderFulfilled=true;
			}else{
				//If the credit card number is invalid, then fail the order.
				paymentService.failedOrder(order.getOrderId());
			}
		}else{
			//If the quantity of order product is not there in inventory, then fail the order
			paymentService.failedOrder(order.getOrderId());
		}

		return orderFulfilled;
	}

	//As the payment gateway is going to charge us a service fee each time, we invoke the interface, we will try to validate the credit card number before
	//it reaches the payment gateway.
	private boolean isValidCreditCardNum(String creditCardNumber){
		String card = creditCardNumber.replaceAll("[^0-9]+", ""); // This is to remove all non-numerics like "-"
		if ((card == null) || (card.length() < 13) || (card.length() > 16)) {
			return false;
		}
		return true;
	}
}
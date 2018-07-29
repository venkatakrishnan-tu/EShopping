package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.model.OrderStatus;

/**
 * 
 * @author poornima
 *
 */
@Component
public class OrderFulfillmentServiceImpl implements OrderFulfillmentService{

	private static final String INVALID_CREDITCARD_NUMBER = "Invalid Creditcard number.";
	private static final String INVENTORY_FAIL = "Not enough quantities in the inventory.";

	@Autowired
	InventoryService inventoryService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	ShipmentService shipmentService;
	
	@Autowired
	OrderService orderService;

	//Step1: Check of the placed order product quantity is in the database. 
			//Step2: If the checkInventory passes, validate the payment credit card.
			//Step3a:If the credit card num is valid, pass it on the payment gateway and ship the order.
			//Step3b:If the credit card num is invalid, fail the order with FAILURE status and corresponding comment.
			//Step4: If Step2 fails, fail the order with FAILURE status and corresponding comment.
	@Override
	public boolean placeOrder(Order order){
		boolean orderFulfilled=false;
		if(inventoryService.checkInventory(Integer.toString(order.getProductId()), order.getQuantity())){
			if(isValidCreditCardNum(order.getCreditCardNo())){
				paymentService.chargePayment(order.getCreditCardNo(), order.getTotalPrice());
				shipmentService.shipOrder(order);
				orderFulfilled=true;
			}else{
				//If the credit card number is invalid, then fail the order.
				order.setStatus(OrderStatus.FAILURE.getStatus());
				order.setComment(INVALID_CREDITCARD_NUMBER);
				orderService.persistOrder(order);
			}
		}else{
			//If the quantity of order product is not there in inventory, then fail the order
			order.setStatus(OrderStatus.FAILURE.getStatus());
			order.setComment(INVENTORY_FAIL);
			orderService.persistOrder(order);		
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
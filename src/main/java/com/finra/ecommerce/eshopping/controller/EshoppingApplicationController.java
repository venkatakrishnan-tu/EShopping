package com.finra.ecommerce.eshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.service.OrderFulfillmentService;
import com.finra.ecommerce.eshopping.service.OrderService;

/*
 * @author Poornima
 */
@RestController
public class EshoppingApplicationController {


	private static final String ORDER_FAILURE = "FAILURE";
	private static final String ORDER_SUCCESS = "SUCCESS";

	@Autowired
	OrderFulfillmentService orderfulFillmentService;

	@Autowired
	OrderService orderService;

	//Create an order
	@RequestMapping(value= "/orders", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		StringResponse response = null; 
		if(orderfulFillmentService.placeOrder(order)){
			response = new StringResponse(ORDER_SUCCESS);
		}else{
			response = new StringResponse(ORDER_FAILURE);
		}
		return ResponseEntity.ok(response);
	}

	//Get an order
	@RequestMapping(value= "/orders/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable("id") int id) {
		return  new ResponseEntity<Order>(orderService.getProduct(id), HttpStatus.OK);
	}

	private class StringResponse {
		private String response;

		//We need to have these getter and setter method to avoid-  No converter found for return value of type exception during the response formatting
		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		public StringResponse(String s) { 
			this.response = s;
		}
	}
}

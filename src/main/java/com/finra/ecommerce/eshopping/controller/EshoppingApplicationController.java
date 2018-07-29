package com.finra.ecommerce.eshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.service.OrderFulfillmentService;
import com.finra.ecommerce.eshopping.service.OrderService;

/*
 * @author Poornima
 */
@RestController
public class EshoppingApplicationController {
	 
 
	@Autowired
	OrderFulfillmentService orderfulFillmentService;
	
	@Autowired
	OrderService orderService;
	
	//Create an order
    @RequestMapping(value= "/orders", method = RequestMethod.POST)
    public String createOrder(@RequestBody Order order) {
    	return (orderfulFillmentService.placeOrder(order) == true) ? "SUCCESS" : "FAILURE"; 
    }
    
  //Get an order
    @RequestMapping(value= "/orders/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PathVariable("id") int id) {
    	 return  new ResponseEntity<Order>(orderService.getOrder(id), HttpStatus.OK);
    }
    
}

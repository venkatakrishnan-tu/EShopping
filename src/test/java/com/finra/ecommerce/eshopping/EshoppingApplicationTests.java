package com.finra.ecommerce.eshopping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.model.OrderStatus;
import com.finra.ecommerce.eshopping.model.User;
import com.finra.ecommerce.eshopping.service.OrderFulfillmentService;
import com.finra.ecommerce.eshopping.service.OrderService;
import com.finra.ecommerce.eshopping.service.ProductService;
import com.finra.ecommerce.eshopping.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EshoppingApplicationTests {

	@Autowired
	private OrderFulfillmentService orderFulfillmentService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void whenOrderHasLessInventory() {
		Order order= new Order(3, "TestingOrder1", "TestingOrder1 Address", "TestingOrder1 city", "zip1", "CREATED", "Test", 12.89, 3, 3, "1212-1212-1212-1212", 5);
		assertEquals(orderFulfillmentService.placeOrder(order), false);

		//assert if the order status is failure.
		assertThat(orderService.getProduct(3).getStatus())
		.isEqualTo(OrderStatus.FAILURE.getStatus());
		
		assertThat(orderService.getProduct(3).getComment())
		.isEqualTo("Not enough quantities in the inventory.");
	}


	@Test
	public void whenOrderHasInvalidCreditCard() {
		Order order= new Order(3, "TestingOrder2", "TestingOrder2 Address", "TestingOrder2 city", "zip2", "CREATED", "Test", 12.89, 3, 3, "121243354", 1);
		assertEquals(orderFulfillmentService.placeOrder(order), false);

		//assert if the order status is failure.
		assertThat(orderService.getProduct(3).getStatus())
		.isEqualTo(OrderStatus.FAILURE.getStatus());
		assertThat(orderService.getProduct(3).getComment())
		.isEqualTo("Invalid Creditcard number.");
	}
	
	
	//In this test we are going to test the successful execution of placing order. After the order is placed, the product inventory quantity should
	//be updated with the current existing quantity.
	@Test
	public void successfulOrder() {
		//Inorder to mock the order placement, we can test it with a new email for the user.
		User user = new User(3, "Mock USER","mockemail@email.com");
		userService.updateUser(user);
		
		Order order= new Order(3, "TestingOrder3", "TestingOrder3 Address", "TestingOrder3 city", "zip3", "CREATED", "Test", 12.89, 3, 3, "1212-1212-1212-1212", 1);
		int currentQtyBeforePlacingOrder = productService.getProduct(order.getProductId()).getQuantity();

		assertEquals(orderFulfillmentService.placeOrder(order), true);

		int qtyAfterPlacingOrder = productService.getProduct(order.getProductId()).getQuantity();
		
		//assert if the order status is successful.
		assertThat(orderService.getProduct(3).getStatus())
		.isEqualTo(OrderStatus.SUCCESS.getStatus());
		
		//assert if the database product quantity is updated with the quantity after the order.
		assertThat(qtyAfterPlacingOrder)
		.isEqualTo(currentQtyBeforePlacingOrder - order.getQuantity());
	}
}

package com.finra.ecommerce.eshopping.model;

/**
 * 
 * @author poornima
 *
 */
public enum OrderStatus
{
	CREATED("CREATED"), SUCCESS("SUCCESS"), FAILURE("FAILURE");
    private final String status;

    private OrderStatus(String orderStatus) {
        this.status = orderStatus;
    }

	public String getStatus() {
		return status;
	}
}

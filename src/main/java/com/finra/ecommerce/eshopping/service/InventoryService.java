package com.finra.ecommerce.eshopping.service;

import com.finra.ecommerce.eshopping.model.Product;

/*
 * @author Poornima
 */
public interface InventoryService {
	public Product getProduct(int productId);
	public boolean checkInventory(String productId, int qty);
}

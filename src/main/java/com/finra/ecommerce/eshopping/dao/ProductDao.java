package com.finra.ecommerce.eshopping.dao;

import com.finra.ecommerce.eshopping.model.Product;
/*
 * @author Poornima
 */
public interface ProductDao {
	public boolean getProductIfAvailable(int id, int qty);
	public void update(Product product, int orderQty );
	public boolean insert(Product product);
	Product findById(int id);
}
package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.dao.ProductDao;
import com.finra.ecommerce.eshopping.model.Product;
/**
 * 
 * @author poornima
 *
 */
@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDAO;
	
 
	@Override
	public Product getProduct(int productId) {
		return productDAO.findById(productId);
	}

 
}

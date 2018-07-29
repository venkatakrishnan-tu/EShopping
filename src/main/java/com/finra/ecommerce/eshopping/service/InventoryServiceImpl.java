package com.finra.ecommerce.eshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finra.ecommerce.eshopping.dao.ProductDao;
import com.finra.ecommerce.eshopping.model.Product;

/*
 * @author Poornima
 */
@Component
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	ProductDao productDAO;

	@Override
	public boolean checkInventory(String productId, int qty) {
		if(isNumeric(productId)){
			int productInt = Integer.parseInt(productId);
			return productDAO.getProductIfAvailable(productInt, qty);
		}		
		return false;
	}

	private boolean isNumeric(String str)  
	{  
		try{  
			double d = Double.parseDouble(str);  
		}catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;  
	}

	@Override
	public Product getProduct(int productId) {
		return productDAO.findById(productId);
	}
}

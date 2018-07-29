package com.finra.ecommerce.eshopping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.finra.ecommerce.eshopping.model.Order;
import com.finra.ecommerce.eshopping.model.Product;

/*
 * @author Poornima
 */
@Repository
public class ProductDaoImpl implements ProductDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final class ProductMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setTitle(rs.getString("title"));
			product.setPrice(rs.getString("price"));
			product.setDescription(rs.getString("description"));
			product.setCreated(rs.getDate("created"));
			product.setQuantity(rs.getInt("quantity"));
			return product;
		}
	}

	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public Product getProductIfAvailable(int id, int qty) {
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("productId",new Integer(id));
        params.put("qty",new Integer(qty));
        
		String sql = "SELECT * FROM products WHERE product_id=:productId AND quantity >=:qty";
		
		Product result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new ProductMapper());        
        return result;
	}
 
	 

	@Override
	public Product findById(int id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("productId",new Integer(id));
        
		String sql = "SELECT * FROM products WHERE product_id=:productId";
		
		Product result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new ProductMapper());        
        return result;
        
	}


	@Override
	public void update(Product product, int orderQty) {
		String sql = "UPDATE products SET quantity =:qty  WHERE product_id=:productId";
		 
		//Once the product is shipped, update the inventory
		int decreaseQty = product.getQuantity()-orderQty;
		 
		namedParameterJdbcTemplate.update(sql,  new MapSqlParameterSource("qty", new Integer(decreaseQty)).addValue("productId", product.getProductId()));
		 
	 
	}
	
	@Override
	public boolean insert(Product product) {
		// TODO Auto-generated method stub
		return true;
	}


}
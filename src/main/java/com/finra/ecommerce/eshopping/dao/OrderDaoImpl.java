package com.finra.ecommerce.eshopping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.finra.ecommerce.eshopping.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final class OrderMapper implements RowMapper<Order> {

		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setId(rs.getInt("order_id"));
			order.setName(rs.getString("name"));
			order.setAddress(rs.getString("address"));
			order.setCity(rs.getString("city"));
			order.setZip(rs.getString("zip"));
			order.setStatus(rs.getString("status"));
			order.setComment(rs.getString("comment"));
			order.setTotalPrice(rs.getDouble("total_price"));
			order.setCreditCardNo(rs.getString("credit_card_num"));
			order.setUserId(rs.getInt("user_id_fk"));
			order.setProductId(rs.getInt("product_id_fk"));
			order.setQuantity(rs.getInt("quantity"));
			return order;
		}
	}


	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Order findById(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id",new Integer(id));
		String sql = "SELECT * FROM orders WHERE order_id=:id";
		Order result = namedParameterJdbcTemplate.queryForObject(
				sql,
				params,
				new OrderMapper());        
		return result;
	}

	@Override
	public List<Order> findAllOrders() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM orders";
		List<Order> result = namedParameterJdbcTemplate.query(sql, params, new OrderMapper());
		return result;

	}


	@Override
	public void processOrder(int id, String status) {
		String sql = "UPDATE orders SET status =:orderStatus  WHERE order_id=:orderId";
		namedParameterJdbcTemplate.update(sql,  new MapSqlParameterSource("orderStatus", status).addValue("orderId", new Integer(id)));
	}

	@Override
	public void persistOrder(Order order) {
		String sql = "UPDATE orders SET name = :name, address = :address, city = :city, zip = :zip, status = :status, comment = :comment, total_price = :totalPrice, credit_card_num = :creditCard, quantity = :qty  WHERE order_id = :orderId";

		namedParameterJdbcTemplate.update(sql,  new MapSqlParameterSource()
                									.addValue("name", order.getName())
                									.addValue("address", order.getAddress())
                									.addValue("city", order.getCity())
                									.addValue("zip", order.getZip())
                									.addValue("status", order.getStatus())
                									.addValue("status", order.getStatus())
                									.addValue("comment", order.getComment())
                									.addValue("totalPrice", order.getTotalPrice())
                									.addValue("creditCard", order.getCreditCardNo())
                									.addValue("qty", order.getQuantity())
                									.addValue("orderId", order.getOrderId()));
	}

}
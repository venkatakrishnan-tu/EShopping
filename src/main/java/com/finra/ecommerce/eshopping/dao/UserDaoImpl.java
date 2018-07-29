package com.finra.ecommerce.eshopping.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.finra.ecommerce.eshopping.model.User;
/*
 * @author Poornima
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setCreated(rs.getDate("created"));
			return user;
		}
	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public User findById(long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", new Long(id));
		String sql = "SELECT * FROM users WHERE user_id=:id";
		User result = namedParameterJdbcTemplate.queryForObject(sql,params,new UserRowMapper());
		return result;
	}

	@Override
	public List<User> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM users";
		List<User> result = namedParameterJdbcTemplate.query(sql, params, new UserRowMapper());
		return result;

	}

	@Override
	public int updateUser(User user) {
	 	String sql = "UPDATE users SET user_id =:userId, name =:name, email=:email WHERE user_id=:userId";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("userId", user.getUserId());
		namedParameters.put("name", user.getName());
		namedParameters.put("email", user.getEmail());
		namedParameterJdbcTemplate.update(sql,  namedParameters);
		return user.getUserId();
	}
}
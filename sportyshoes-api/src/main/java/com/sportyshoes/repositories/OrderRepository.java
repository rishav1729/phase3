package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.OrderDao;
import com.sportyshoes.models.Order;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class OrderRepository implements OrderDao{
	
	@Autowired
	private DatabaseConnection connection;

	@Override
	public Integer createOrder(Order order) throws SQLException{
		// TODO Auto-generated method stub
		String insertOrderFormat = "INSERT INTO orders (product_id, user_id, order_date) VALUES (?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertOrderFormat);) {
			preparedStatement.setInt(1, order.getProductId());
			preparedStatement.setInt(2, order.getUserId());
			preparedStatement.setTimestamp(3, order.getOrderDate());
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public List<Order> findAllOrders() throws SQLException{
		// TODO Auto-generated method stub
		String getOrdersFormat = "SELECT * FROM orders";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductId(rs.getInt("product_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				
				orders.add(order);
			}

			return orders;
		}
	}

	@Override
	public List<Order> findOrdersByOrderDateAsc() throws SQLException{
		// TODO Auto-generated method stub
		String getOrdersFormat = "SELECT * FROM orders ORDER BY order_date ASC";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductId(rs.getInt("product_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				
				orders.add(order);
			}

			return orders;
		}
	}

	@Override
	public List<Order> findOrdersByOrderDateDesc() throws SQLException{
		// TODO Auto-generated method stub
		String getOrdersFormat = "SELECT * FROM orders ORDER BY order_date DESC";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductId(rs.getInt("product_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				
				orders.add(order);
			}

			return orders;
		}
	}

	@Override
	public List<Order> findOrdersByOrderIdAsc() throws SQLException{
		// TODO Auto-generated method stub
		String getOrdersFormat = "SELECT * FROM orders ORDER BY id ASC";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductId(rs.getInt("product_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				
				orders.add(order);
			}

			return orders;
		}
	}

	@Override
	public List<Order> findOrdersByOrderIdDesc() throws SQLException{
		// TODO Auto-generated method stub
		String getOrdersFormat = "SELECT * FROM orders ORDER BY id DESC";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductId(rs.getInt("product_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				
				orders.add(order);
			}

			return orders;
		}
	}

	@Override
	public List<Order> findOrdersByProductId(Integer product_id) throws SQLException{
		// TODO Auto-generated method stub
		String getOrdersFormat = "SELECT * FROM orders WHERE product_id = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
			preparedStatement.setInt(1, product_id);
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductId(rs.getInt("product_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				
				orders.add(order);
			}

			return orders;
		}
	}

	@Override
	public List<Order> findOrdersByUserId(Integer user_id) throws SQLException {
		// TODO Auto-generated method stub
		String getOrdersFormat = "SELECT * FROM orders WHERE user_id = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getOrdersFormat);) {
			preparedStatement.setInt(1, user_id);
			ResultSet rs = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return orders;
			}

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductId(rs.getInt("product_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDate(rs.getTimestamp("order_date"));
				
				orders.add(order);
			}

			return orders;
		}
	}

}

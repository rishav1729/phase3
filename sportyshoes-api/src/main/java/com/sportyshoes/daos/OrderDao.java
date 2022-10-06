package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import com.sportyshoes.models.Order;

public interface OrderDao {
	// Create Operation
	Integer createOrder(Order order) throws SQLException;
	
	// Read/Retrieve Operations
	List<Order> findAllOrders() throws SQLException;
	List<Order> findOrdersByOrderDateAsc() throws SQLException;
	List<Order> findOrdersByOrderDateDesc() throws SQLException;
	List<Order> findOrdersByOrderIdAsc() throws SQLException;
	List<Order> findOrdersByOrderIdDesc() throws SQLException;
	List<Order> findOrdersByProductId(Integer product_id) throws SQLException;
	List<Order> findOrdersByUserId(Integer user_id) throws SQLException;
	
}

package com.sportyshoes.services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Order;
import com.sportyshoes.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Boolean addOrder(int productId, int userId) {
		Order order = new Order(productId, userId, Timestamp.from(Instant.now())); 
		try {
			return orderRepository.createOrder(order) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Order> getAllOrders() {
		try {
			return orderRepository.findAllOrders();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Order> getOrdersByProductId(int productId) {
		try {
			return orderRepository.findOrdersByProductId(productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Order> getOrdersByUserId(int userId) {
		try {
			return orderRepository.findOrdersByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Order> getOrdersByKeyAndOrder(String key, String order) {
		try {
			switch(order) {
			case "ASC":
				if(key.equalsIgnoreCase("id")) {
					return orderRepository.findOrdersByOrderIdAsc();
				}else if(key.equalsIgnoreCase("date")) {
					return orderRepository.findOrdersByOrderDateAsc();
				}
				break;
			case "DESC":
				if(key.equalsIgnoreCase("id")) {
					return orderRepository.findOrdersByOrderIdDesc();
				}else if(key.equalsIgnoreCase("date")) {
					return orderRepository.findOrdersByOrderDateDesc();
				}
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

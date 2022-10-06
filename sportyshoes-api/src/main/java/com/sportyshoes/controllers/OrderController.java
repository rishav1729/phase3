package com.sportyshoes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Order;
import com.sportyshoes.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping("/user/{userId}/product/{productId}")
	public Map<String, String> purchaseProduct(@PathVariable Integer userId, @PathVariable Integer productId) {
		Map<String, String> productAddedResponse = new HashMap<String, String>();
		Boolean productAdded = orderService.addOrder(productId,userId);
		if(productAdded) {
			productAddedResponse.put("status", "true");
			productAddedResponse.put("message", "Purchased product successfully");
		} else {
			productAddedResponse.put("status", "false");
			productAddedResponse.put("message", "Invalid inputs");
		}
		return productAddedResponse;
	}
	
	@GetMapping("/all")
	public List<Order> getAllProducts() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/search/productid/{productid}")
	public List<Order> searchByProductId(@PathVariable Integer productid) {
		return orderService.getOrdersByProductId(productid);
	}
	
	@GetMapping("/search/userid/{userid}")
	public List<Order> searchByUserId(@PathVariable Integer userid) {
		return orderService.getOrdersByUserId(userid);
	}
	
	@GetMapping("/searchbykeyandorder")
	public List<Order> searchByKeyAndOrder(@RequestParam String key, @RequestParam String order) {
		return orderService.getOrdersByKeyAndOrder(key,order);
	}
	
}

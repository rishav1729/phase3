package com.sportyshoes.models;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the order")
public class Order {
	@ApiModelProperty(notes = "The unique id of the order")
	int id;
	@ApiModelProperty(notes = "product details of the order")
	int productId;
	@ApiModelProperty(notes = "user details of the order")
	int userId;
	@ApiModelProperty(notes = "Date/Time of the order")
	Timestamp orderDate;
		

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int productId, int userId, Timestamp orderDate) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", productId=" + productId + ", userId=" + userId + ", orderDate=" + orderDate + "]";
	}
	

}

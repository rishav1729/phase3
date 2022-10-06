package com.sportyshoes.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the product")
public class Product {
	@ApiModelProperty(notes = "The unique id of the product")
	int id;
	@ApiModelProperty(notes = "Name of the product")
	String name;
	@ApiModelProperty(notes = "MSRP of the product")
	double msrp;
	@ApiModelProperty(notes = "quantity_in_stock of the product")
	int quantityInStock;
	@ApiModelProperty(notes = "product_vendor of the product")
	String productVendor;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double msrp, int quantityInStock, String productVendor) {
		super();
		this.name = name;
		this.msrp = msrp;
		this.quantityInStock = quantityInStock;
		this.productVendor = productVendor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", msrp=" + msrp + ", quantityInStock=" + quantityInStock
				+ ", productVendor=" + productVendor + "]";
	}

}

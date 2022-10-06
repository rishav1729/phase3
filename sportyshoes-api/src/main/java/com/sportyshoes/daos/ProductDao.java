package com.sportyshoes.daos;

import java.sql.SQLException;
import java.util.List;

import com.sportyshoes.models.Product;

public interface ProductDao {
	// Create Operation
	Integer createProduct(Product product) throws SQLException;
	
	// Read/Retrieve Operations
	Product findProductById(Integer id) throws SQLException;
	List<Product> findProductsByName(String name) throws SQLException;
	List<Product> findAllProducts() throws SQLException;
	
	// Update Operations
	Integer updateProduct(Product product) throws SQLException;
	
	// Delete Operations
	Integer deleteProductById(Integer id) throws SQLException;	
}

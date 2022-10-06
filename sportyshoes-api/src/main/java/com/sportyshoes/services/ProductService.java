package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Product;
import com.sportyshoes.repositories.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		try {
			return productRepository.findAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean addProduct(String name, Double msrp, int quantity, String vendor) {
		Product product = new Product(name, msrp, quantity, vendor); 
		try {
			return productRepository.createProduct(product) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Product getByProductId(int id) {
		try {
			return productRepository.findProductById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> getByProductName(String name) {
		try {
			return productRepository.findProductsByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean updateProductName(int id, String newName) {
		Product product = getByProductId(id);
		product.setName(newName);
		try {
			return productRepository.updateProduct(product) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean updateProductMsrp(int id, Double msrp) {
		Product product = getByProductId(id);
		product.setMsrp(msrp);
		try {
			return productRepository.updateProduct(product) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Boolean updateProductQuantity(int id, int quantity) {
		Product product = getByProductId(id);
		product.setQuantityInStock(quantity);
		try {
			return productRepository.updateProduct(product) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean updateProductVendor(int id, String vendor) {
		Product product = getByProductId(id);
		product.setProductVendor(vendor);
		try {
			return productRepository.updateProduct(product) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean deleteProductById(int id) {

		try {
			return productRepository.deleteProductById(id) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

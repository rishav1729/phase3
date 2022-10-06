package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.ProductDao;
import com.sportyshoes.models.Product;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class ProductRepository implements ProductDao{

	@Autowired
	private DatabaseConnection connection;
	
	@Override
	public Integer createProduct(Product product) throws SQLException {
		String insertProductFormat = "INSERT INTO products (name, msrp, quantity_in_stock, product_vendor) VALUES (?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertProductFormat);) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getMsrp());
			preparedStatement.setInt(3, product.getQuantityInStock());
			preparedStatement.setString(4, product.getProductVendor());
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Product findProductById(Integer id) throws SQLException {
		String getProductFormat = "SELECT * FROM products WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getProductFormat);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Product product = new Product();
			while (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setMsrp(rs.getDouble("msrp"));
				product.setQuantityInStock(rs.getInt("quantity_in_stock"));
				product.setProductVendor(rs.getString("product_vendor"));
			}
			return product;
		}
	}

	@Override
	public List<Product> findProductsByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		String getUsersFormat = "SELECT * FROM products where name = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUsersFormat);) {
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			List<Product> products = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return products;
			}

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setMsrp(rs.getDouble("msrp"));
				product.setQuantityInStock(rs.getInt("quantity_in_stock"));
				product.setProductVendor(rs.getString("product_vendor"));
				
				products.add(product);
			}

			return products;
		}
	}

	@Override
	public List<Product> findAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		String getUsersFormat = "SELECT * FROM products";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUsersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Product> products = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return products;
			}

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setMsrp(rs.getDouble("msrp"));
				product.setQuantityInStock(rs.getInt("quantity_in_stock"));
				product.setProductVendor(rs.getString("product_vendor"));
				
				products.add(product);
			}

			return products;
		}
	}

	@Override
	public Integer updateProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String updateProductFormat = "UPDATE products SET id = ?, name = ?, msrp = ?, quantity_in_stock = ?, product_vendor = ? WHERE id = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateProductFormat);) {
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getMsrp());
			preparedStatement.setInt(4, product.getQuantityInStock());
			preparedStatement.setString(5, product.getProductVendor());
			preparedStatement.setInt(6, product.getId());
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer deleteProductById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String deleteProductFormat = "DELETE FROM products WHERE id = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteProductFormat);) {
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		}
	}

}

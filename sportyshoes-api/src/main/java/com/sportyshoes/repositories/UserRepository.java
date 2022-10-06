package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.UserDao;
import com.sportyshoes.models.User;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class UserRepository implements UserDao{
	
	@Autowired
	private DatabaseConnection connection;
	
	// Create Operation
	public Integer createUser(User user) throws SQLException {
		String insertUserFormat = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(insertUserFormat);) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			return preparedStatement.executeUpdate();
		}

	}
	
	// Read/Retrieve Operations
	public User findUserById(Integer id) throws SQLException {
		// Read (Retrieve) Operation using PreparedStatement
		String getUserFormat = "SELECT * FROM users WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUserFormat);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			User user = new User();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
			return user;
		}
	}
	
	public User findUserByNameAndPassword(String username, String password) throws SQLException{
		// Read (Retrieve) Operation using PreparedStatement
				String getUserFormat = "SELECT * FROM users WHERE name = ? and password = ?";
				try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUserFormat);) {
					preparedStatement.setString(1, username);
					preparedStatement.setString(2, password);
					ResultSet rs = preparedStatement.executeQuery();

					if (!rs.isBeforeFirst()) {
						return null;
					}

					User user = new User();
					while (rs.next()) {
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
					}
					return user;
				}
	}
	
	public List<User> findAllUsers() throws SQLException{
		String getUsersFormat = "SELECT * FROM users";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUsersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<User> users = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return users;
			}

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}

			return users;
		}
		
	}
	
	@Override
	public List<User> findUsersByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		String getUsersFormat = "SELECT * FROM users where name = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getUsersFormat);) {
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			List<User> users = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return users;
			}

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}

			return users;
		}
	}
	
	// Update Operations
	public  Integer updateUser(User user) throws SQLException{
		String updateUserFormat = "UPDATE users SET id = ?, name = ?, email = ?, password = ? WHERE id = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateUserFormat);) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getId());
			return preparedStatement.executeUpdate();
		}
	}

	// Delete Operations
	public Integer deleteUserById(Integer id) throws SQLException {
		String deleteUserFormat = "DELETE FROM users WHERE id = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(deleteUserFormat);) {
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		}
	}

}

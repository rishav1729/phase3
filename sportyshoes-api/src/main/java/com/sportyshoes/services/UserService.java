package com.sportyshoes.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.User;
import com.sportyshoes.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Boolean registerUser(String username, String email, String password) {
		User user = new User(username, email, password); 
		try {
			return userRepository.createUser(user) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean signInUser(String username, String password) {
		try {
			return userRepository.findUserByNameAndPassword(username,password) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUserById(int id) {
		try {
			return userRepository.findUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<User> getAllUsers() {
		try {
			return userRepository.findAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<User> getUsersByUserName(String name) {
		try {
			return userRepository.findUsersByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Boolean updateUsername(int id, String newName) {
		User user = getUserById(id);
		user.setName(newName);
		try {
			return userRepository.updateUser(user) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean updatePassword(int id, String newpassword) {
		User user = getUserById(id);
		user.setPassword(newpassword);
		try {
			return userRepository.updateUser(user) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}

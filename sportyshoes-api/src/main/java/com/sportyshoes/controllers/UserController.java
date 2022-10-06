package com.sportyshoes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.User;
import com.sportyshoes.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired 
	UserService userService;
	
	@PostMapping("/signup")
	public Map<String, String> signup(@RequestParam MultiValueMap<String, String> newUserDetails) {
		Map<String, String> signUpResponse = new HashMap<String, String>();
		Boolean userRegistered = userService.registerUser(newUserDetails.getFirst("username"),newUserDetails.getFirst("email"),newUserDetails.getFirst("password"));
		if(userRegistered) {
			signUpResponse.put("status", "true");
			signUpResponse.put("message", "User has been registered successfully");
		} else {
			signUpResponse.put("status", "false");
			signUpResponse.put("message", "User registration failed");
		}
		return signUpResponse;
	}
	
	@PostMapping("/signin")
	public Map<String, String> signin(@RequestParam MultiValueMap<String, String> credentials) {
		Map<String, String> signInResponse = new HashMap<String, String>();
		Boolean userAuthenticated = userService.signInUser(credentials.getFirst("username"),credentials.getFirst("password"));
		if(userAuthenticated) {
			signInResponse.put("status", "true");
			signInResponse.put("message", "User has been authenticated successfully");
		} else {
			signInResponse.put("status", "false");
			signInResponse.put("message", "User authentication failed");
		}
		return signInResponse;
	}
	
	@GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable String userId) {
        return userService.getUserById(Integer.parseInt(userId));
    }
	
	@GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
	
	@GetMapping("/search")
    public List<User> getUserByUserName(@RequestParam String username) {
        return userService.getUsersByUserName(username);
    }
	
	@PatchMapping("/{userId}/update/username")
    public Map<String, String> updateUserName(@PathVariable String userId, @RequestParam String newUserName) {
		Map<String, String> updateResponse = new HashMap<String, String>();
		Boolean userUpdated = userService.updateUsername(Integer.parseInt(userId), newUserName);
        
        if(userUpdated) {
        	updateResponse.put("status", "true");
			updateResponse.put("message", "User has been updated successfully");
		} else {
			updateResponse.put("status", "false");
			updateResponse.put("message", "Invalid input");
		}
		return updateResponse;
    }

    @PatchMapping("/{userId}/update/password")
    public Map<String, String> updateUserPassword(@PathVariable String userId, @RequestParam String newPassword) {
    	Map<String, String> updateResponse = new HashMap<String, String>();
    	Boolean userUpdated = userService.updatePassword(Integer.parseInt(userId), newPassword);
        if(userUpdated) {
        	updateResponse.put("status", "true");
			updateResponse.put("message", "User has been updated successfully");
		} else {
			updateResponse.put("status", "false");
			updateResponse.put("message", "Invalid input");
		}
		return updateResponse;
        
    }
	
}

package com.sportyshoes.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired 
	AdminService adminService;
	
	@PostMapping("/signin")
	public Map<String, String> signin(@RequestParam MultiValueMap<String, String> credentials) {
		Map<String, String> signInResponse = new HashMap<String, String>();
		Boolean userAuthenticated = adminService.signInAdmin(credentials.getFirst("username"),credentials.getFirst("password"));
		if(userAuthenticated) {
			signInResponse.put("status", "true");
			signInResponse.put("message", "Admin has been authenticated successfully");
		} else {
			signInResponse.put("status", "false");
			signInResponse.put("message", "Admin authentication failed");
		}
		return signInResponse;
	}
	
	@PatchMapping("/{id}/update/password")
    public Boolean updateAdminPassword(@PathVariable String id, @RequestParam String newPassword) {
        return adminService.updatePassword(Integer.parseInt(id), newPassword);
    }
}

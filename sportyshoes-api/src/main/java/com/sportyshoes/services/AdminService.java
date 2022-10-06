package com.sportyshoes.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.models.Admin;
import com.sportyshoes.repositories.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public Boolean signInAdmin(String username, String password) {
		try {
			return adminRepository.findAdminByUsernameAndPassword(username,password) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Admin getAdminById(int id) {
		try {
			return adminRepository.findAdminById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean updatePassword(int id, String newpassword) {
		Admin admin = getAdminById(id);
		admin.setPassword(newpassword);
		try {
			return adminRepository.updateAdmin(admin) != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

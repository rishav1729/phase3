package com.sportyshoes.daos;

import java.sql.SQLException;

import com.sportyshoes.models.Admin;

public interface AdminDao {
				
	// Read/Retrieve Operations
	Admin findAdminById(Integer id) throws SQLException;
	Admin findAdminByUsernameAndPassword(String username, String password) throws SQLException;
	
	// Update Operations
	Integer updateAdmin(Admin admin) throws SQLException;
	
}

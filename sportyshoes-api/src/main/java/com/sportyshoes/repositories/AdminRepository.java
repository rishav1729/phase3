package com.sportyshoes.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.daos.AdminDao;
import com.sportyshoes.models.Admin;
import com.sportyshoes.utils.DatabaseConnection;

@Repository
public class AdminRepository implements AdminDao{

	@Autowired
	private DatabaseConnection connection;
	
	@Override
	public Admin findAdminById(Integer id) throws SQLException{
		// Read (Retrieve) Operation using PreparedStatement
		String getAdminFormat = "SELECT * FROM admins WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getAdminFormat);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Admin admin = new Admin();
			while (rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
			}
			return admin;
		}
	}
	
	@Override
	public Admin findAdminByUsernameAndPassword(String username, String password) throws SQLException{
		// Read (Retrieve) Operation using PreparedStatement
		String getAdminFormat = "SELECT * FROM admins WHERE name = ? and password = ?";
		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(getAdminFormat);) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Admin admin = new Admin();
			while (rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
			}
			return admin;
		}
	}

	@Override
	public Integer updateAdmin(Admin admin) throws SQLException{
		String updateUserFormat = "UPDATE admins SET id = ?, name = ?, password = ? WHERE id = ?";

		try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(updateUserFormat);) {
			preparedStatement.setInt(1, admin.getId());
			preparedStatement.setString(2, admin.getName());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setInt(4, admin.getId());
			return preparedStatement.executeUpdate();
		}
	}

}

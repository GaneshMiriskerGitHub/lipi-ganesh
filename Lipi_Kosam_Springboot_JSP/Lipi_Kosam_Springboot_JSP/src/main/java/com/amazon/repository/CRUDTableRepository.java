package com.amazon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CRUDTableRepository {

	public String deleteUserDetails(String userid) throws Exception {
		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "4935");

		// Step 3
		String query = "Delete From UserDetails where userid = ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, userid);

		int rowsAffected = st.executeUpdate();

		if (rowsAffected > 0) {
			return "SUCCESS";
		} else {
			return "No user found with the given userid.";
		}
	}

	public String updateUserDetails(String userid, String username, String adharno, String email) throws Exception {
		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "4935");

		// Step 3
		String query = "UPDATE UserDetails SET username = ?, adharcardno = ?, email = ? where userid = ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, username);
		st.setString(2, adharno);
		st.setString(3, email);
		st.setString(4, userid);

		int rowsAffected = st.executeUpdate();

		if (rowsAffected > 0) {
			return "SUCCESS";
		} else {
			return "No user found with the given userid.";
		}
	}
	
	public String addNewUserDetails(String username, String adharno, String email) throws Exception {
		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "4935");

		// Step 3
		String query = "INSERT INTO UserDetails(username, adharcardno, email) values(?, ?, ?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, username);
		st.setString(2, adharno);
		st.setString(3, email);

		int rowsAffected = st.executeUpdate();

		if (rowsAffected > 0) {
			return "SUCCESS";
		} else {
			return "No user found with the given userid.";
		}
	}

}

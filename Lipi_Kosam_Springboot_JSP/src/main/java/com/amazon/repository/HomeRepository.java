package com.amazon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class HomeRepository {

	public String getPasswordFor(String username) throws Exception {
		
		String DBpassword = "";
		
		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "4935");
		
		//  Step 3
		String query = "SELECT * FROM USER WHERE username = ? ";
		PreparedStatement st = con.prepareStatement(query);
		
		st.setString(1, username);

		ResultSet rs = st.executeQuery();

		// Process the results
		while (rs.next()) {
			DBpassword = rs.getString("password");
		}
		
		return DBpassword;

	}

}

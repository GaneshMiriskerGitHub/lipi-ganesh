package com.amazon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class DropDownRepository {

	public List<String> getCustCodeList() throws Exception {

		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "4935");

		// Step 3
		String query = "SELECT * FROM custcodes";
		PreparedStatement st = con.prepareStatement(query);


		ResultSet rs = st.executeQuery();

		List<String> custCodeList = new ArrayList<>();
		// Process the results
		while (rs.next()) {
			custCodeList.add(rs.getString("custcodes")) ;
		}

		return custCodeList;

	}

}

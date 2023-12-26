package com.amazon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazon.dto.UserDetailsDTO;

@Repository
public class UserDetailsTableRepository {
	
	public List<UserDetailsDTO> getAllUserDetails() throws Exception {

		List<UserDetailsDTO> userDtoList = new ArrayList<>();

		// Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "4935");

		// Step 3
		String query = "select * from UserDetails";
		PreparedStatement st = con.prepareStatement(query);


		ResultSet rs = st.executeQuery();

		// Process the results
		while (rs.next()) {
			UserDetailsDTO userdtoObj = new UserDetailsDTO();
			userdtoObj.setId(rs.getInt("userid"));
			userdtoObj.setUsername(rs.getString("username"));
			userdtoObj.setEmail(rs.getString("email"));
			userdtoObj.setAdharcardno(rs.getString("adharcardno"));
			userDtoList.add(userdtoObj);
		}

		return userDtoList;

	}

}

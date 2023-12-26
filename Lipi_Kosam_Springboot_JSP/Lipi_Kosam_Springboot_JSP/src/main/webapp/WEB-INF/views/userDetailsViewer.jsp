<%@ page import="java.util.List" %>
<%@ page import="com.amazon.dto.UserDetailsDTO" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 68%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #D8D8D8;
}
</style>
</head>
<body>



<center>
<h2>HTML Table</h2>
<table>
  <tr>
    <th>User ID</th>
    <th>User Name</th>
    <th>Aadhar Card No</th>
  </tr>
  <%
  List<UserDetailsDTO> userdetailsData = (List<UserDetailsDTO>) request.getAttribute("userdetailsData");
  for (UserDetailsDTO userDetails : userdetailsData) {
  %>
  <tr>
    <td><%= userDetails.getId() %></td>
    <td><%= userDetails.getUsername() %></td>
    <td><%= userDetails.getAdharcardno() %></td>
  </tr>
  <%
  }
  %>
</table>
</center>

</body>
</html>

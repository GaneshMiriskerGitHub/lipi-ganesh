<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dropdown Example</title>
</head>
<body>
    <h1>Dropdown Example</h1>
    
    <form action="/" method="post">
        <label for="dropdown">Select an option:</label>
        <select name="dropdown" id="dropdown">
            <%
                // Retrieve the list of options from the request attribute
                List<String> dropdownData = (List<String>) request.getAttribute("dropdownData");
                
                // Iterate over the options and generate the <option> elements
                for (String option : dropdownData) {
            %>
            <option value="<%= option %>"><%= option %></option>
            <%
                }
            %>
        </select>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Spring Boot JSP</title>
</head>
<body>
    <h1>${message}</h1>
    
    <form method="post" action="/openForm">
        <button type="submit">Open Form</button>
    </form>
</body>
</html>

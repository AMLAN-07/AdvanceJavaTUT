<%@ page import="entity.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
<h2>Student Details</h2>
<p>ID: <%= student.getId() %></p>
<p>Name: <%= student.getName() %></p>
<p>Email: <%= student.getEmail() %></p>
<p>Registration No: <%= student.getRegdno() %></p>
<p>Password: <%= student.getPassword() %></p>
</body>
</html>
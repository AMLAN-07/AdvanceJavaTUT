<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Student Management - College ERP</title>
</head>

<body>

<h1>Student Management</h1>

<p>
    Welcome, ${sessionScope.username}!
</p>

<hr>

<a href="<%= request.getContextPath() %>/student?action=add">
    Add New Student
</a>

<br><br>

<table border="1" cellpadding="8">

    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Age</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="student" items="${students}">

        <tr>

            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td>${student.age}</td>
            <td>${student.phone}</td>
            <td>${student.address}</td>

            <td>
                <a href="<%= request.getContextPath() %>/student?action=edit&id=${student.id}">
                    Edit
                </a>
                |
                <a href="<%= request.getContextPath() %>/student?action=delete&id=${student.id}"
                   onclick="return confirm('Are you sure you want to delete this student?');">
                    Delete
                </a>
            </td>
        </tr>

    </c:forEach>

    </tbody>

</table>

<br>

<a href="<%= request.getContextPath() %>/dashboard">
    Main Dashboard
</a>

<br><br>

<a href="<%= request.getContextPath() %>/logout">
    Logout
</a>

</body>

</html>
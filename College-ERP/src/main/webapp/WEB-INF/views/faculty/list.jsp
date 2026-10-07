<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Faculty Management - College ERP</title>
</head>

<body>

<h1>Faculty Management</h1>

<p>
    Welcome, ${sessionScope.username}!
</p>

<hr>

<a href="<%= request.getContextPath() %>/faculty?action=add">
    Add New Faculty
</a>

<br><br>

<table border="1" cellpadding="8">

    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Designation</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="faculty" items="${faculties}">

        <tr>

            <td>${faculty.id}</td>

            <td>${faculty.name}</td>

            <td>${faculty.email}</td>

            <td>${faculty.department}</td>

            <td>${faculty.designation}</td>

            <td>${faculty.phone}</td>

            <td>${faculty.address}</td>

            <td>

                <a href="<%= request.getContextPath() %>/faculty?action=edit&id=${faculty.id}">
                    Edit
                </a>

                |

                <a href="<%= request.getContextPath() %>/faculty?action=delete&id=${faculty.id}"
                   onclick="return confirm('Are you sure you want to delete this faculty?');">
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
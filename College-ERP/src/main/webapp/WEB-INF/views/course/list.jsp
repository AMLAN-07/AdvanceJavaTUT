<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Course Management - College ERP</title>
</head>

<body>

<h1>Course Management</h1>

<p>
    Welcome, ${sessionScope.username}!
</p>

<hr>

<a href="<%= request.getContextPath() %>/course?action=add">
    Add New Course
</a>

<br><br>

<table border="1" cellpadding="8">

    <thead>
    <tr>
        <th>ID</th>
        <th>Course Code</th>
        <th>Course Name</th>
        <th>Department</th>
        <th>Duration</th>
        <th>Credits</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="course" items="${courses}">

        <tr>

            <td>${course.id}</td>

            <td>${course.courseCode}</td>

            <td>${course.courseName}</td>

            <td>${course.department}</td>

            <td>${course.duration}</td>

            <td>${course.credits}</td>

            <td>${course.description}</td>

            <td>

                <a href="<%= request.getContextPath() %>/course?action=edit&id=${course.id}">
                    Edit
                </a>

                |

                <a href="<%= request.getContextPath() %>/course?action=delete&id=${course.id}"
                   onclick="return confirm('Are you sure you want to delete this course?');">
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
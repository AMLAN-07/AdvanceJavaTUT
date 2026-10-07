<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Faculty Dashboard - College ERP</title>
</head>

<body>

<h1>Faculty Dashboard</h1>

<h2>
    Welcome, ${sessionScope.username}!
</h2>

<p>
    Role: ${sessionScope.role}
</p>

<p>
    Email: ${sessionScope.email}
</p>

<hr>

<h2>Faculty Management</h2>

<ul>
    <li>My Courses</li>
    <li>Mark Attendance</li>
    <li>Upload Results</li>
    <li>Student Performance</li>
</ul>

<hr>

<a href="<%= request.getContextPath() %>/dashboard">
    Main Dashboard
</a>

<br><br>

<a href="<%= request.getContextPath() %>/logout">
    Logout
</a>

</body>
</html>
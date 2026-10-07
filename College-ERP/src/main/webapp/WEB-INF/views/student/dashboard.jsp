<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard - College ERP</title>
</head>

<body>

<h1>Student Dashboard</h1>

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

<h2>Student Management</h2>

<ul>
    <li>My Profile</li>
    <li>My Attendance</li>
    <li>My Results</li>
    <li>My Timetable</li>
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
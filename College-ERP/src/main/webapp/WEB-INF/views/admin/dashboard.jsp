<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - College ERP</title>
</head>

<body>

<h1>Admin Dashboard</h1>

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

<h2>Administration</h2>

<ul>

    <li>
        <a href="<%= request.getContextPath() %>/student">
            Student Management
        </a>
    </li>
    <li>
        <a href="<%= request.getContextPath() %>/faculty">
            Faculty Management
        </a>
    </li>
    <li>
        <a href="<%= request.getContextPath() %>/course">
            Course Management
        </a>
    </li>
    <li>Attendance Management</li>
    <li>Result Management</li>
    <li>Reports</li>

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
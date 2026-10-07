<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>College ERP - Dashboard</title>
</head>

<body>

<h1>College ERP Dashboard</h1>

<h2>
    Welcome, ${sessionScope.username}!
</h2>

<p>
    Role: ${sessionScope.role}
</p>

<p>
    Email: ${sessionScope.email}
</p>

<p>
    <a href="<%= request.getContextPath() %>/logout">
        Logout
    </a>
</p>

<hr>

<c:choose>

    <c:when test="${sessionScope.role == 'ADMIN'}">

        <h2>Administrator Dashboard</h2>

        <ul>

            <li>
                <a href="<%= request.getContextPath() %>/admin/dashboard">
                    Admin Dashboard
                </a>
            </li>

            <li>Student Management</li>
            <li>Faculty Management</li>
            <li>Course Management</li>
            <li>Attendance Management</li>
            <li>Result Management</li>
            <li>Reports</li>

        </ul>

    </c:when>

    <c:when test="${sessionScope.role == 'FACULTY'}">

        <h2>Faculty Dashboard</h2>

        <ul>

            <li>
                <a href="<%= request.getContextPath() %>/faculty/dashboard">
                    Faculty Dashboard
                </a>
            </li>

            <li>My Courses</li>
            <li>Mark Attendance</li>
            <li>Upload Results</li>
            <li>Student Performance</li>

        </ul>

    </c:when>

    <c:when test="${sessionScope.role == 'STUDENT'}">

        <h2>Student Dashboard</h2>

        <ul>

            <li>My Profile</li>
            <li>My Attendance</li>
            <li>My Results</li>
            <li>My Timetable</li>

        </ul>

    </c:when>

    <c:otherwise>

        <h2>Access Denied</h2>

        <p>
            Your account does not have a valid role.
        </p>

    </c:otherwise>

</c:choose>

</body>
</html>

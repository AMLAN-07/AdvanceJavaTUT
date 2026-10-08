<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Attendance Management</title>
</head>

<body>

<h1>Attendance Management</h1>

<p>
    <a href="<%= request.getContextPath() %>/attendance?action=add">
        Add Attendance
    </a>
</p>

<table border="1" cellpadding="8" cellspacing="0">

    <tr>
        <th>ID</th>
        <th>Student ID</th>
        <th>Date</th>
        <th>Status</th>
        <th>Remarks</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="attendance"
               items="${attendanceList}">

        <tr>

            <td>${attendance.id}</td>

            <td>${attendance.studentId}</td>

            <td>${attendance.attendanceDate}</td>

            <td>${attendance.status}</td>

            <td>${attendance.remarks}</td>

            <td>

                <a href="<%= request.getContextPath() %>/attendance?action=edit&id=${attendance.id}">
                    Edit
                </a>

                |

                <a href="<%= request.getContextPath() %>/attendance?action=delete&id=${attendance.id}"
                   onclick="return confirm('Are you sure you want to delete this attendance record?');">
                    Delete
                </a>

            </td>

        </tr>

    </c:forEach>

</table>

<p>
    <a href="<%= request.getContextPath() %>/admin/dashboard">
        Back to Admin Dashboard
    </a>
</p>

</body>
</html>
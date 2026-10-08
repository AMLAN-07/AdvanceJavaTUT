<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Result Management</title>
</head>

<body>

<h1>Result Management</h1>

<p>
    <a href="<%= request.getContextPath() %>/result?action=add">
        Add Result
    </a>
</p>

<table border="1" cellpadding="8" cellspacing="0">

    <tr>
        <th>ID</th>
        <th>Student ID</th>
        <th>Course ID</th>
        <th>Marks</th>
        <th>Grade</th>
        <th>Semester</th>
        <th>Remarks</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="result"
               items="${resultList}">

        <tr>

            <td>${result.id}</td>

            <td>${result.studentId}</td>

            <td>${result.courseId}</td>

            <td>${result.marks}</td>

            <td>${result.grade}</td>

            <td>${result.semester}</td>

            <td>${result.remarks}</td>

            <td>

                <a href="<%= request.getContextPath() %>/result?action=edit&id=${result.id}">
                    Edit
                </a>

                |

                <a href="<%= request.getContextPath() %>/result?action=delete&id=${result.id}"
                   onclick="return confirm('Are you sure you want to delete this result?');">
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
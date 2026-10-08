<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Attendance</title>
</head>

<body>

<h1>Edit Attendance</h1>

<form action="<%= request.getContextPath() %>/attendance"
      method="post">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="id"
           value="${attendance.id}">

    <p>
        <label>Student ID:</label>
        <input type="number"
               name="studentId"
               value="${attendance.studentId}"
               required>
    </p>

    <p>
        <label>Attendance Date:</label>
        <input type="date"
               name="attendanceDate"
               value="${attendance.attendanceDate}"
               required>
    </p>

    <p>
        <label>Status:</label>

        <select name="status" required>

            <option value="PRESENT"
            ${attendance.status == 'PRESENT' ? 'selected' : ''}>
                PRESENT
            </option>

            <option value="ABSENT"
            ${attendance.status == 'ABSENT' ? 'selected' : ''}>
                ABSENT
            </option>

        </select>
    </p>

    <p>
        <label>Remarks:</label>
        <input type="text"
               name="remarks"
               value="${attendance.remarks}"
               maxlength="255">
    </p>

    <p>
        <button type="submit">
            Update Attendance
        </button>
    </p>

</form>

<p>
    <a href="<%= request.getContextPath() %>/attendance">
        Cancel
    </a>
</p>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Attendance</title>
</head>

<body>

<h1>Add Attendance</h1>

<form action="<%= request.getContextPath() %>/attendance"
      method="post">

    <input type="hidden"
           name="action"
           value="add">

    <p>
        <label>Student ID:</label>
        <input type="number"
               name="studentId"
               required>
    </p>

    <p>
        <label>Attendance Date:</label>
        <input type="date"
               name="attendanceDate"
               required>
    </p>

    <p>
        <label>Status:</label>

        <select name="status" required>
            <option value="">-- Select Status --</option>
            <option value="PRESENT">PRESENT</option>
            <option value="ABSENT">ABSENT</option>
        </select>
    </p>

    <p>
        <label>Remarks:</label>
        <input type="text"
               name="remarks"
               maxlength="255">
    </p>

    <p>
        <button type="submit">
            Add Attendance
        </button>
    </p>

</form>

<p>
    <a href="<%= request.getContextPath() %>/attendance">
        Back to Attendance List
    </a>
</p>

</body>
</html>
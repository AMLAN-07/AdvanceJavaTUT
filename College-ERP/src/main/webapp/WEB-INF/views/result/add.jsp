<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Result</title>
</head>

<body>

<h1>Add Result</h1>

<form action="<%= request.getContextPath() %>/result"
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
        <label>Course ID:</label>
        <input type="number"
               name="courseId"
               required>
    </p>

    <p>
        <label>Marks:</label>
        <input type="number"
               name="marks"
               min="0"
               max="100"
               step="0.01"
               required>
    </p>

    <p>
        <label>Grade:</label>
        <select name="grade" required>
            <option value="">-- Select Grade --</option>
            <option value="A+">A+</option>
            <option value="A">A</option>
            <option value="B+">B+</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
            <option value="F">F</option>
        </select>
    </p>

    <p>
        <label>Semester:</label>
        <input type="number"
               name="semester"
               min="1"
               max="12"
               required>
    </p>

    <p>
        <label>Remarks:</label>
        <input type="text"
               name="remarks"
               maxlength="255">
    </p>

    <p>
        <button type="submit">
            Add Result
        </button>
    </p>

</form>

<p>
    <a href="<%= request.getContextPath() %>/result">
        Back to Result List
    </a>
</p>

</body>
</html>
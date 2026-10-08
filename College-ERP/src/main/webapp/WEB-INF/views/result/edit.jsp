<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Result</title>
</head>

<body>

<h1>Edit Result</h1>

<form action="<%= request.getContextPath() %>/result"
      method="post">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="id"
           value="${result.id}">

    <p>
        <label>Student ID:</label>
        <input type="number"
               name="studentId"
               value="${result.studentId}"
               required>
    </p>

    <p>
        <label>Course ID:</label>
        <input type="number"
               name="courseId"
               value="${result.courseId}"
               required>
    </p>

    <p>
        <label>Marks:</label>
        <input type="number"
               name="marks"
               value="${result.marks}"
               min="0"
               max="100"
               step="0.01"
               required>
    </p>

    <p>
        <label>Grade:</label>

        <select name="grade" required>

            <option value="A+"
            ${result.grade == 'A+' ? 'selected' : ''}>
                A+
            </option>

            <option value="A"
            ${result.grade == 'A' ? 'selected' : ''}>
                A
            </option>

            <option value="B+"
            ${result.grade == 'B+' ? 'selected' : ''}>
                B+
            </option>

            <option value="B"
            ${result.grade == 'B' ? 'selected' : ''}>
                B
            </option>

            <option value="C"
            ${result.grade == 'C' ? 'selected' : ''}>
                C
            </option>

            <option value="D"
            ${result.grade == 'D' ? 'selected' : ''}>
                D
            </option>

            <option value="F"
            ${result.grade == 'F' ? 'selected' : ''}>
                F
            </option>

        </select>
    </p>

    <p>
        <label>Semester:</label>
        <input type="number"
               name="semester"
               value="${result.semester}"
               min="1"
               max="12"
               required>
    </p>

    <p>
        <label>Remarks:</label>
        <input type="text"
               name="remarks"
               value="${result.remarks}"
               maxlength="255">
    </p>

    <p>
        <button type="submit">
            Update Result
        </button>
    </p>

</form>

<p>
    <a href="<%= request.getContextPath() %>/result">
        Cancel
    </a>
</p>

</body>
</html>
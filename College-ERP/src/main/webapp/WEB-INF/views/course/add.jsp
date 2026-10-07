<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Course - College ERP</title>
</head>

<body>

<h1>Add New Course</h1>

<form method="post"
      action="<%= request.getContextPath() %>/course">

    <label>Course Code:</label><br>
    <input type="text"
           name="courseCode"
           required>
    <br><br>

    <label>Course Name:</label><br>
    <input type="text"
           name="courseName"
           required>
    <br><br>

    <label>Department:</label><br>
    <input type="text"
           name="department"
           required>
    <br><br>

    <label>Duration:</label><br>
    <input type="text"
           name="duration"
           placeholder="e.g. 4 Years">
    <br><br>

    <label>Credits:</label><br>
    <input type="number"
           name="credits"
           min="0"
           max="100"
           required>
    <br><br>

    <label>Description:</label><br>
    <textarea name="description"
              rows="5"
              cols="40"></textarea>
    <br><br>

    <button type="submit">
        Add Course
    </button>

</form>

<br>

<a href="<%= request.getContextPath() %>/course">
    Back to Course List
</a>

<br><br>

<a href="<%= request.getContextPath() %>/dashboard">
    Main Dashboard
</a>

</body>
</html>
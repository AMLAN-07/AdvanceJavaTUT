<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Course - College ERP</title>
</head>

<body>

<h1>Edit Course</h1>

<form method="post"
      action="<%= request.getContextPath() %>/course">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="id"
           value="${course.id}">

    <label>Course Code:</label><br>
    <input type="text"
           name="courseCode"
           value="${course.courseCode}"
           required>
    <br><br>

    <label>Course Name:</label><br>
    <input type="text"
           name="courseName"
           value="${course.courseName}"
           required>
    <br><br>

    <label>Department:</label><br>
    <input type="text"
           name="department"
           value="${course.department}"
           required>
    <br><br>

    <label>Duration:</label><br>
    <input type="text"
           name="duration"
           value="${course.duration}">
    <br><br>

    <label>Credits:</label><br>
    <input type="number"
           name="credits"
           value="${course.credits}"
           min="0"
           max="100"
           required>
    <br><br>

    <label>Description:</label><br>
    <textarea name="description"
              rows="5"
              cols="40">${course.description}</textarea>
    <br><br>

    <button type="submit">
        Update Course
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
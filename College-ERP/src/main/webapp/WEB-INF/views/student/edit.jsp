<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student - College ERP</title>
</head>

<body>

<h1>Edit Student</h1>

<form method="post"
      action="<%= request.getContextPath() %>/student">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="id"
           value="${student.id}">

    <label>Name:</label><br>
    <input type="text"
           name="name"
           value="${student.name}"
           required>
    <br><br>

    <label>Email:</label><br>
    <input type="email"
           name="email"
           value="${student.email}"
           required>
    <br><br>

    <label>Course:</label><br>
    <input type="text"
           name="course"
           value="${student.course}"
           required>
    <br><br>

    <label>Age:</label><br>
    <input type="number"
           name="age"
           value="${student.age}"
           min="1"
           max="100"
           required>
    <br><br>

    <label>Phone:</label><br>
    <input type="text"
           name="phone"
           value="${student.phone}">
    <br><br>

    <label>Address:</label><br>
    <textarea name="address"
              rows="4"
              cols="30">${student.address}</textarea>
    <br><br>

    <button type="submit">
        Update Student
    </button>

</form>

<br>

<a href="<%= request.getContextPath() %>/student">
    Back to Student List
</a>

<br><br>

<a href="<%= request.getContextPath() %>/dashboard">
    Main Dashboard
</a>

</body>
</html>
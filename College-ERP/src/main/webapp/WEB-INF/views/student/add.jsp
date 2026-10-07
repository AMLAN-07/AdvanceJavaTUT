<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <title>Add Student - College ERP</title>
</head>

<body>

<h1>Add New Student</h1>

<form method="post"
      action="<%= request.getContextPath() %>/student">

    <label>Name:</label>
    <br>
    <input type="text"
           name="name"
           required>

    <br><br>

    <label>Email:</label>
    <br>
    <input type="email"
           name="email"
           required>

    <br><br>

    <label>Course:</label>
    <br>
    <input type="text"
           name="course"
           required>

    <br><br>

    <label>Age:</label>
    <br>
    <input type="number"
           name="age"
           min="1"
           max="100"
           required>

    <br><br>

    <label>Phone:</label>
    <br>
    <input type="text"
           name="phone">

    <br><br>

    <label>Address:</label>
    <br>
    <textarea name="address"
              rows="4"
              cols="30"></textarea>

    <br><br>

    <button type="submit">
        Add Student
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
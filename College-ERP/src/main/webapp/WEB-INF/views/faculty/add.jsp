<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Faculty - College ERP</title>
</head>

<body>

<h1>Add New Faculty</h1>

<form method="post"
      action="<%= request.getContextPath() %>/faculty">

    <label>Name:</label><br>
    <input type="text"
           name="name"
           required>
    <br><br>

    <label>Email:</label><br>
    <input type="email"
           name="email"
           required>
    <br><br>

    <label>Department:</label><br>
    <input type="text"
           name="department"
           required>
    <br><br>

    <label>Designation:</label><br>
    <input type="text"
           name="designation">
    <br><br>

    <label>Phone:</label><br>
    <input type="text"
           name="phone">
    <br><br>

    <label>Address:</label><br>
    <textarea name="address"
              rows="4"
              cols="30"></textarea>
    <br><br>

    <button type="submit">
        Add Faculty
    </button>

</form>

<br>

<a href="<%= request.getContextPath() %>/faculty">
    Back to Faculty List
</a>

<br><br>

<a href="<%= request.getContextPath() %>/dashboard">
    Main Dashboard
</a>

</body>
</html>
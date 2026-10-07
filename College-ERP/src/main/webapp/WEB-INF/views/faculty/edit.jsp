<%@ page contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Faculty - College ERP</title>
</head>

<body>

<h1>Edit Faculty</h1>

<form method="post"
      action="<%= request.getContextPath() %>/faculty">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="id"
           value="${faculty.id}">

    <label>Name:</label><br>
    <input type="text"
           name="name"
           value="${faculty.name}"
           required>
    <br><br>

    <label>Email:</label><br>
    <input type="email"
           name="email"
           value="${faculty.email}"
           required>
    <br><br>

    <label>Department:</label><br>
    <input type="text"
           name="department"
           value="${faculty.department}"
           required>
    <br><br>

    <label>Designation:</label><br>
    <input type="text"
           name="designation"
           value="${faculty.designation}">
    <br><br>

    <label>Phone:</label><br>
    <input type="text"
           name="phone"
           value="${faculty.phone}">
    <br><br>

    <label>Address:</label><br>
    <textarea name="address"
              rows="4"
              cols="30">${faculty.address}</textarea>
    <br><br>

    <button type="submit">
        Update Faculty
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
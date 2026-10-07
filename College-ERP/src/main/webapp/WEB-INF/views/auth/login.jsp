<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>College ERP - Login</title>
</head>

<body>

<h1>College ERP Login</h1>
<% if (request.getAttribute("error") != null) { %>

<p style="color: red;">
    <%= request.getAttribute("error") %>
</p>

<% } %>
<form method="post" action="<%= request.getContextPath() %>/login">

    <div>
        <label>Username</label>
        <input type="text"
               name="username"
               required>
    </div>

    <br>

    <div>
        <label>Password</label>
        <input type="password"
               name="password"
               required>
    </div>

    <br>

    <button type="submit">
        Login
    </button>

</form>

</body>
</html>
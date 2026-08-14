<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Saved</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 600px; margin: auto auto 20px auto; background: #fff; padding: 30px;
                border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        h2 { color: #27ae60; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }
        th { background: #2980b9; color: white; }
        tr:nth-child(even) { background: #f9f9f9; }
        a.button {
            display: inline-block; margin-top: 20px; padding: 10px 16px;
            background: #2980b9; color: white; text-decoration: none; border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>&#10003; Student saved successfully!</h2>
        <%
            Student newStudent = (Student) request.getAttribute("newStudent");
        %>
        <p><b>ID:</b> <%= newStudent.getId() %></p>
        <p><b>Name:</b> <%= newStudent.getName() %></p>
        <p><b>Age:</b> <%= newStudent.getAge() %></p>
        <p><b>Email:</b> <%= newStudent.getEmail() %></p>
        <p><b>Course:</b> <%= newStudent.getCourse() %></p>

        <a class="button" href="index.jsp">Add Another Student</a>
    </div>

    <div class="card">
        <h2 style="color:#2c3e50;">All Students in Database</h2>
        <table>
            <tr>
                <th>ID</th><th>Name</th><th>Age</th><th>Email</th><th>Course</th>
            </tr>
            <%
                List<Student> studentList = (List<Student>) request.getAttribute("studentList");
                for (Student s : studentList) {
            %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAge() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCourse() %></td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>

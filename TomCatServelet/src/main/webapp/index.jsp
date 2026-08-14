<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 420px; margin: auto; background: #fff; padding: 30px;
                border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        h2 { text-align: center; color: #2c3e50; }
        label { display: block; margin-top: 15px; font-weight: bold; color: #34495e; }
        input, select {
            width: 100%; padding: 8px; margin-top: 5px; box-sizing: border-box;
            border: 1px solid #ccc; border-radius: 4px;
        }
        button {
            margin-top: 20px; width: 100%; padding: 10px; background: #2980b9;
            color: white; border: none; border-radius: 4px; font-size: 16px; cursor: pointer;
        }
        button:hover { background: #1f6391; }
        .error { color: #c0392b; text-align: center; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Student Registration</h2>

        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>

        <form action="submit" method="post">
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" required>

            <label for="age">Age</label>
            <input type="number" id="age" name="age" min="1" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="course">Course</label>
            <select id="course" name="course">
                <option value="Computer Science">Computer Science</option>
                <option value="Mechanical">Mechanical</option>
                <option value="Electrical">Electrical</option>
                <option value="Civil">Civil</option>
                <option value="Business">Business</option>
            </select>

            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>

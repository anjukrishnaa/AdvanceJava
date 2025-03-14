<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Delete Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Delete Student</h2>

        <form action="StudentServlet" method="post">
            <input type="hidden" name="action" value="delete">

            <label>Student ID:</label>
            <input type="number" name="ID" required><br>

            <button type="submit">Delete Student</button>
        </form>
    </div>
</body>
</html>
<%@ page import="java.util.*, com.example.dao.StudentDAOImpl" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Add Student</h2>
        <form action="StudentServlet" method="post">
            <input type="hidden" name="action" value="add">

            <label>Name:</label>
            <input type="text" name="name" required><br>

            <label>Roll No:</label>
            <input type="text" name="rollNo" required><br>

            <label>Marks:</label>
            <input type="number" name="marks" required><br>

            <label>Department:</label>
            <select name="deptId" required>
                <%
                    StudentDAOImpl studentDAO = new StudentDAOImpl();
                    List<String> departments = studentDAO.getDepartments();
                    for (String dept : departments) {
                        String[] parts = dept.split(" - ");
                %>
                <option value="<%= parts[0] %>"><%= parts[1] %></option>
                <%
                    }
                %>
            </select><br>

            <button type="submit">Add Student</button>
        </form>
    </div>
</body>
</html>
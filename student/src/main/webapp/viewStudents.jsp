<%@ page import="java.util.*, com.example.dao.StudentDAOImpl" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>View Students</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Student List</h2>

        <%
            StudentDAOImpl studentDAO = new StudentDAOImpl();
            List<String> students = studentDAO.getAllStudents();

            if (students.isEmpty()) {
                out.println("<p>No students found.</p>");
            } else {
        %>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Roll No</th>
                <th>Marks</th>
                <th>Department</th>
            </tr>

            <%
                for (String student : students) {
                    String[] details = student.split(", ");
            %>
            <tr>
                <td><%= details[0].split(": ")[1] %></td>
                <td><%= details[1].split(": ")[1] %></td>
                <td><%= details[2].split(": ")[1] %></td>
                <td><%= details[3].split(": ")[1] %></td>
                <td><%= details[4].split(": ")[1] %></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }
        %>
    </div>
</body>
</html>
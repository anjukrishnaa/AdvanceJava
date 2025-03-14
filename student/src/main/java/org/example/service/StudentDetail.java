package org.example.service;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDetail {
    private List<Student> studentlist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Connection con = null;

    public StudentDetail() {

        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

        } catch (Exception ex) {
            System.out.println("Driver Not Found");
        }
    }


    public void addStudent() throws SQLException {
        try {

            System.out.println("Enter the name of the student: ");
            String name = sc.next();
            System.out.println("Enter the roll number of the student: ");
            int roll_no = sc.nextInt();
            System.out.println("Enter the marks of the student: ");
            int marks = sc.nextInt();
            System.out.println("Enter the branch id");
            int branchid = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("Insert into school.student(name,roll_no,marks,branchid)values (?,?,?,?);");
            ps.setString(1, name);

            ps.setInt(2, roll_no);
            ps.setInt(3, marks);
            ps.setInt(4, branchid);
            int rowupdate = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in inserting in student" + e.getMessage());
        }


    }

    public void deleteStudent() throws SQLException {
        try {
            System.out.println("Enter the roll no which you want to delete");
            int rNo = sc.nextInt();
            PreparedStatement ps = con.prepareStatement("delete from student where roll_no=?");
            ps.setInt(1, rNo);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("No student was found with given rollno");
            }

        } catch (SQLException e) {
            System.out.println("Error in deleting student" + e.getMessage());
        }

    }


    public void readStudent() throws SQLException {

        try {

            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("Select * from Student");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") + " ID: " + rs.getInt("id")
                        + " Roll NO: " + rs.getInt("roll_no") + " Marks: " + rs.getInt("marks")
                        + " Branch id: " + rs.getInt("branchid"));

            }
        } catch (SQLException e) {
            System.out.println("error in retriviewing student" + e.getMessage());
        }
    }
}



package org.example;

import org.example.model.Student;
import org.example.service.StudentDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException {
        ArrayList<Student> studentlist = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        StudentDetail sd = new StudentDetail();
        int option;


        do {
            System.out.println("1. Add student\n 2. Read student \n 3. Remove student \n 4. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    sd.addStudent();
                    break;
                case 2:
                    sd.readStudent();
                    break;
                case 3:
                    sd.deleteStudent();
                    break;
                case 4:
                    System.out.println("exit");
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        } while (option != 4);
    }

}

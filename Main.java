package com.Maven;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.connect();
        if (conn != null) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        AddStudent.addStudent(conn);
                        break;
                    case 2:
                        ViewStudents.viewStudents(conn);
                        break;
                    case 3:
                        UpdateStudent.updateStudent(conn);
                        break;
                    case 4:
                        DeleteStudent.deleteStudent(conn);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        }
    }
}


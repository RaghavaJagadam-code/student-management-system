package com.Maven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddStudent {
    public static void addStudent(Connection conn) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt for student details
            System.out.println("Enter Student Name:");
            String name = scanner.nextLine();

            System.out.println("Enter Student Age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            System.out.println("Enter Student Course:");
            String course = scanner.nextLine();

            // SQL to insert student
            String sql = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, course);

                int rowsAffected = pstmt.executeUpdate();
                System.out.println(rowsAffected > 0 ? "Student added successfully!" : "Failed to add the student.");
            } catch (SQLException e) {
                System.out.println("Error while adding the student: " + e.getMessage());
            }

            // Ask if user wants to add another student
            System.out.println("Do you want to add another student? (yes/no):");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Returning to main menu...");
                break;
            }
        }
    }
}

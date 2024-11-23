package com.Maven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {
    public static void updateStudent(Connection conn) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter New Course: ");
            String course = scanner.nextLine();

            String sql = "UPDATE students SET course = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course);
            pstmt.setInt(2, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


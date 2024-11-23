package com.Maven;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewStudents {
    public static void viewStudents(Connection conn) {
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ID\tName\t\tAge\tCourse");
            System.out.println("------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.printf("%d\t%s\t\t%d\t%s\n", id, name, age, course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


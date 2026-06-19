package fileio;

import java.io.FileWriter;
import java.io.IOException;

public class StudentFileWriter {
    public void writeStudent(String name, String studentId, String email, String phone, String course, double gpa) {
        try {
            FileWriter writer = new FileWriter("students.txt", true);
            writer.write("Name: " + name + " | ID: " + studentId + " | Email: " + email + " | Phone: " + phone + " | Course: " + course + " | GPA: " + gpa + "\n");
            writer.close();
            System.out.println("Student saved to file: " + name);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
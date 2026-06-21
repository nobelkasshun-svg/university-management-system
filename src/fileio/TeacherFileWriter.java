package fileio;

import java.io.FileWriter;
import java.io.IOException;

public class TeacherFileWriter {
    public void writeTeacher(String name, String email, String phone, String department) {
        try {
            FileWriter writer = new FileWriter("teachers.txt", true);
            writer.write("Name: " + name + " | Email: " + email + " | Phone: " + phone + " | Department: " + department + "\n");
            writer.close();
            System.out.println("Teacher saved to file: " + name);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
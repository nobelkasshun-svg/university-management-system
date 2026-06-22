package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeacherFileReader {
    public void readTeachers() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("teachers.txt"));
            String line;
            System.out.println("--- Teachers from File ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
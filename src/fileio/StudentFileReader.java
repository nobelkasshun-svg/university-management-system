package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentFileReader {
    public void readStudents() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            System.out.println("--- Students from File ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
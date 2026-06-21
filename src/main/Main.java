package main;

import exceptions.*;
import model.Student;
import model.Teacher;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== University Management System =====\n");

        System.out.println("--- Test 1: Valid Student ---");
        try {
            Student s1 = new Student("Biruk Alemu", 21, "biruk@university.edu", "+251911000001", "UGR/0113/24", "Computer Science", 3.5);
            s1.displayInfo();
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n--- Test 2: Invalid Age ---");
        try {
            Student s2 = new Student("Abel Tesfaye", -5, "abel@university.edu", "+251911000002", "UGR/0200/24", "Software Engineering", 3.0);
            s2.displayInfo();
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        } catch (InvalidNameException e) {
            System.out.println("Caught InvalidNameException: " + e.getMessage());
        }

        System.out.println("\n--- Test 3: Invalid Name ---");
        try {
            Student s3 = new Student("", 20, "s3@university.edu", "+251911000003", "UGR/0300/24", "Math", 2.8);
            s3.displayInfo();
        } catch (InvalidNameException e) {
            System.out.println("Caught InvalidNameException: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        }

        System.out.println("\n--- Test 4: Valid Teacher ---");
        try {
            Teacher t1 = new Teacher("Dr. Hailu Mersha", 45, "hailu@university.edu", "+251922000001", "Software Engineering");
            t1.displayInfo();
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n--- Test 5: Student Not Found ---");
        try {
            findStudent("UGR/9999/99");
        } catch (StudentNotFoundException e) {
            System.out.println("Caught StudentNotFoundException: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
        }

        System.out.println("\n--- Test 6: Duplicate Student ---");
        try {
            registerStudent("UGR/0113/24");
        } catch (DuplicateStudentException e) {
            System.out.println("Caught DuplicateStudentException: " + e.getMessage());
        }

        System.out.println("\n--- Test 7: Enrollable ---");
        try {
            Student s5 = new Student("Luna Lovegood", 19, "luna@university.edu", "+251911000005", "UGR/0500/24", "Magical Studies", 3.9);

            System.out.println("[Before enrollment]");
            s5.displayInfo();

            System.out.println("\n[Enrolling student]");
            s5.enroll("Defense Against the Dark Arts");

            System.out.println("\n[After enrollment]");
            s5.displayInfo(true);
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n--- Test 8: Searchable ---");
        try {
            Student s5 = new Student("Luna Lovegood", 19, "luna@university.edu", "+251911000005", "UGR/0500/24", "Magical Studies", 3.9);
            s5.enroll("Defense Against the Dark Arts");

            Teacher t1 = new Teacher("Dr. Hailu Mersha", 45, "hailu@university.edu", "+251922000001", "Software Engineering");

            System.out.println("Search 'Luna':");
            System.out.println("  Student matches: " + s5.matchesSearch("Luna"));
            System.out.println("  Teacher matches: " + t1.matchesSearch("Luna"));

            System.out.println("\nSearch 'Software':");
            System.out.println("  Student matches: " + s5.matchesSearch("Software"));
            System.out.println("  Teacher matches: " + t1.matchesSearch("Software"));System.out.println("\nSearch 'UGR/0500/24':");
            System.out.println("  Student matches: " + s5.matchesSearch("UGR/0500/24"));

            System.out.println("\nSearch 'Defense':");
            System.out.println("  Student matches: " + s5.matchesSearch("Defense"));
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n===== All Tests Completed =====");
    }

    static void findStudent(String id) throws StudentNotFoundException {
        System.out.println("Searching for student: " + id);
        throw new StudentNotFoundException(id);
    }

    static void registerStudent(String id) throws DuplicateStudentException {
        System.out.println("Attempting to register student: " + id);
        throw new DuplicateStudentException(id);
    }
}
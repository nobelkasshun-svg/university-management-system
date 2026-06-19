package main;

import exceptions.*;
import model.Student;
import model.Teacher;
import interfaces.Enrollable;
import interfaces.Printable;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== University Management System =====\n");

        System.out.println("--- Test 1: Valid Student ---");
        try {
            Student s1 = new Student("Biruk Alemu", 21, "UGR/0113/24", "+251911000001", "biruk@university.edu");
            s1.displayInfo();
        } catch (UniversityException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n--- Test 2: Invalid Age ---");
        try {
            Student s2 = new Student("Abel Tesfaye", -5, "UGR/0200/24", "+251911000002", "abel@university.edu");
            s2.displayInfo();
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        } catch (UniversityException e) {
            System.out.println("Caught UniversityException: " + e.getMessage());
        }

        System.out.println("\n--- Test 3: Invalid Name ---");
        try {
            Student s3 = new Student("", 20, "UGR/0300/24", "+251911000003", "s3@university.edu");
            s3.displayInfo();
        } catch (InvalidNameException e) {
            System.out.println("Caught InvalidNameException: " + e.getMessage());
        } catch (UniversityException e) {
            System.out.println("Caught UniversityException: " + e.getMessage());
        }

        System.out.println("\n--- Test 4: Invalid Student ID ---");
        try {
            Student s4 = new Student("Sara Kebede", 22, "S", "+251911000004", "sara@university.edu");
            s4.displayInfo();
        } catch (InvalidStudentIdException e) {
            System.out.println("Caught InvalidStudentIdException: " + e.getMessage());
        } catch (UniversityException e) {
            System.out.println("Caught UniversityException: " + e.getMessage());
        }

        System.out.println("\n--- Test 5: Valid Teacher ---");
        try {
            Teacher t1 = new Teacher("Dr. Hailu Mersha", 45, "Software Engineering", "+251922000001", "hailu@university.edu");
            t1.displayInfo();
        } catch (UniversityException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n--- Test 6: Invalid Subject ---");
        try {
            Teacher t2 = new Teacher("Dr. Tigist Bekele", 38, "", "+251922000002", "tigist@university.edu");
            t2.displayInfo();
        } catch (InvalidSubjectException e) {
            System.out.println("Caught InvalidSubjectException: " + e.getMessage());
        } catch (UniversityException e) {
            System.out.println("Caught UniversityException: " + e.getMessage());
        }

        System.out.println("\n--- Test 7: Student Not Found ---");
        try {
            findStudent("UGR/9999/99");
        } catch (StudentNotFoundException e) {
            System.out.println("Caught StudentNotFoundException: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
        }

        System.out.println("\n--- Test 8: Duplicate Student ---");
        try {
            registerStudent("UGR/0113/24");
        } catch (DuplicateStudentException e) {
            System.out.println("Caught DuplicateStudentException: " + e.getMessage());
        }

        System.out.println("\n--- Test 9: Enrollable & Printable ---");
        try {
            Student s5 = new Student("Luna Lovegood", 19, "UGR/0500/24", "+251911000005", "luna@university.edu");
            
            System.out.println("[Before enrollment]");
            s5.printDetails();
            
            System.out.println("\n[Enrolling student]");
            s5.enroll("Defense Against the Dark Arts");
            
            System.out.println("\n[After enrollment]");
            s5.printDetails();
        } catch (UniversityException e) {
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

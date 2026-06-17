package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidStudentIdException;

public class Student extends Person {
    private String studentId;
    private String courseName;

    public Student(String name, int age, String email, String phoneNumber, String studentId, String courseName)
            throws InvalidNameException, InvalidAgeException, InvalidStudentIdException {
        super(name, age, email, phoneNumber);
        setStudentId(studentId);
        this.courseName = courseName;
    }

    public void setStudentId(String studentId) throws InvalidStudentIdException {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidStudentIdException(studentId);
        }
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    // OVERRIDING - overrides displayInfo() from Person
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + courseName);
    }

    // OVERLOADING - same method name different parameter
    public void displayInfo(boolean showContact) {
        displayInfo();
        if (showContact) {
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phoneNumber);
        }
    }

    public String getRole() {
        return "Student";
    }
}
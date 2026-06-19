package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidStudentIdException;
import interfaces.Enrollable;
import interfaces.Printable;

public class Student extends Person implements Enrollable, Printable {
    private String studentId;
    private String courseName;
    private double gpa;

    public Student(String name, int age, String email, String phoneNumber, String studentId, String courseName, double gpa)
            throws InvalidNameException, InvalidAgeException, InvalidStudentIdException {
        super(name, age, email, phoneNumber);
        setStudentId(studentId);
        this.courseName = courseName;
        this.gpa = gpa;
    }

    public Student(String name, int age, String studentId, String phoneNumber, String email)
            throws InvalidNameException, InvalidAgeException, InvalidStudentIdException {
        this(name, age, email, phoneNumber, studentId, null, 0.0);
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

    public double getGpa() {
        return gpa;
    }

    public boolean isPassingGPA() {
        return gpa >= 2.0;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + courseName);
        System.out.println("GPA: " + gpa);
        System.out.println("Passing: " + isPassingGPA());
    }

    public void displayInfo(boolean showContact) {
        displayInfo();
        if (showContact) {
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phoneNumber);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Student ID: " + studentId + " | Course: " + courseName + " | GPA: " + gpa;
    }

    public String getRole() {
        return "Student";
    }

    @Override
    public void enroll(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        this.courseName = courseName.trim();
        System.out.println("Student " + getName() + " (ID: " + studentId + ") successfully enrolled in: " + this.courseName);
    }

    @Override
    public void printDetails() {
        displayInfo();
    }

    @Override
    public boolean matchesSearch(String keyword) {
        if (super.matchesSearch(keyword)) {
            return true;
        }
        if (keyword == null || keyword.trim().isEmpty()) {
            return false;
        }
        String kw = keyword.toLowerCase().trim();
        return studentId.toLowerCase().contains(kw) ||
               (courseName != null && courseName.toLowerCase().contains(kw));
    }
}
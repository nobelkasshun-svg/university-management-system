package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidStudentIdException;

public class Student extends Person {
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
}
package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidStudentIdException;
import interfaces.Enrollable;
import interfaces.Printable;

public class Student extends Person implements Enrollable, Printable {
    private String studentId;
    private String courseName;

    public Student(String name, int age, String studentId, String phoneNumber, String email)
            throws InvalidNameException, InvalidAgeException, InvalidStudentIdException {
        super(name, age, phoneNumber, email);
        setStudentId(studentId);
    }

    public void setStudentId(String studentId) throws InvalidStudentIdException {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new InvalidStudentIdException(studentId, "Student ID cannot be null or empty");
        }
        if (studentId.length() < 3) {
            throw new InvalidStudentIdException(studentId, "Student ID must be at least 3 characters");
        }
        this.studentId = studentId.trim();
    }

    public String getStudentId() { return studentId; }
    public String getCourseName() { return courseName; }

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
        if (courseName != null) {
            System.out.println("Enrolled Course: " + courseName);
        } else {
            System.out.println("Enrolled Course: Not enrolled");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
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
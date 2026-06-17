package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidStudentIdException;

public class Student extends Person {
    private String studentId;

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

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
    }
}
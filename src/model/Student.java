package model;

public class Student extends Person {
    String studentId;
    String courseName;

    public Student(String name, int age, String email, String phoneNumber, String studentId, String courseName) {
        super(name, age, email, phoneNumber);
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + courseName);
    }

    public String getRole() {
        return "Student";
    }
}
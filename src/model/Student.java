package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import interfaces.Enrollable;
import interfaces.Searchable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Searchable, Enrollable {

    protected String major;
    protected double gpa;
    protected List<String> enrolledCourses;

    public Student(String name, int age, String email, String phoneNumber,
                   String id, String major, double gpa)
            throws InvalidNameException, InvalidAgeException {
        super(name, age, email, phoneNumber, id);
        this.major = major;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student(String name, int age, String email, String phoneNumber, String id)
            throws InvalidNameException, InvalidAgeException {
        this(name, age, email, phoneNumber, id, "Undeclared", 0.0);
    }

    public String getMajor()                { return major; }
    public double getGpa()                  { return gpa; }
    public boolean isPassingGPA()           { return gpa >= 2.0; }
    public List<String> getEnrolledCourses(){ return enrolledCourses; }

    @Override
    public void enroll(String courseName) {
        if (!enrolledCourses.contains(courseName)) {
            enrolledCourses.add(courseName);
            System.out.println(name + " enrolled in: " + courseName);
        } else {
            System.out.println(name + " is already enrolled in: " + courseName);
        }
    }

    @Override
    public boolean matchesSearch(String query) {
        String q = query.toLowerCase();
        return name.toLowerCase().contains(q)
                || id.toLowerCase().contains(q)
                || major.toLowerCase().contains(q)
                || enrolledCourses.stream().anyMatch(c -> c.toLowerCase().contains(q));
    }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public void displayInfo() {
        System.out.printf("%s [ID=%s, Name=%s, Age=%d, Major=%s, GPA=%.2f]%n",
                getRole(), id, name, age, major, gpa);
    }

    public void displayInfo(boolean detailed) {
        displayInfo();
        if (detailed) {
            System.out.println("   Email          : " + email);
            System.out.println("   Phone          : " + phoneNumber);
            System.out.println("   Passing GPA    : " + isPassingGPA());
            System.out.println("   Enrolled       : " + enrolledCourses);
            // ─── Validator Output ───
            System.out.println("   Valid          : " + isValid());
            System.out.println("   Validation     : " + getValidationSummary());
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Major=" + major + ", GPA=" + gpa;
    }
}
package model;

import interfaces.Searchable;
import interfaces.Enrollable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Searchable, Enrollable {

    protected String major;
    protected double gpa;
    protected List<String> enrolledCourses;

    public Student(String name, int age, String email, String phoneNumber,
                    String id, String major, double gpa) {
        super(name, age, email, phoneNumber, id);
        this.major = major;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student(String name, int age, String email, String phoneNumber, String id) {
        this(name, age, email, phoneNumber, id, "Undeclared", 0.0);
    }

    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public boolean isAdult() { return age >= 18; }
    public boolean isPassingGPA() { return gpa >= 2.0; }
    public List<String> getEnrolledCourses() { return enrolledCourses; }

    @Override
    public void enroll(String courseName) {
        enrolledCourses.add(courseName);
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
            System.out.println("   Email: " + email);
            System.out.println("   Phone: " + phoneNumber);
            System.out.println("   Enrolled Courses: " + enrolledCourses);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Major=" + major + ", GPA=" + gpa;
    }
}
package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import interfaces.Attendable;
import interfaces.Enrollable;
import interfaces.Searchable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Searchable, Enrollable, Attendable {

    protected String major;
    protected double gpa;
    protected List<String> enrolledCourses;
    protected int totalDays;
    protected int daysPresent;

    public Student(String name, int age, String email, String phoneNumber,
                    String id, String major, double gpa)
            throws InvalidNameException, InvalidAgeException {
        super(name, age, email, phoneNumber, id);
        validateName(name);
        validateAge(age);
        this.major = major;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
        this.totalDays = 0;
        this.daysPresent = 0;
    }

    public Student(String name, int age, String email, String phoneNumber, String id)
            throws InvalidNameException, InvalidAgeException {
        this(name, age, email, phoneNumber, id, "Undeclared", 0.0);
    }

    private static void validateName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Student name cannot be null or empty");
        }
    }

    private static void validateAge(int age) throws InvalidAgeException {
        if (age <= 0 || age > 120) {
            throw new InvalidAgeException("Student age must be between 1 and 120, got: " + age);
        }
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

    // Attendable implementation
    @Override
    public void markPresent() {
        totalDays++;
        daysPresent++;
    }

    @Override
    public void markAbsent() {
        totalDays++;
    }

    @Override
    public int getTotalDays() {
        return totalDays;
    }

    @Override
    public int getDaysPresent() {
        return daysPresent;
    }

    @Override
    public double getAttendancePercentage() {
        if (totalDays == 0) return 0.0;
        return (daysPresent * 100.0) / totalDays;
    }

    @Override
    public boolean meetsAttendanceRequirement(double requiredPercentage) {
        return getAttendancePercentage() >= requiredPercentage;
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
package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import interfaces.Searchable;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements Searchable {

    protected String department;
    private List<String> coursesTaught;

    public Teacher(String name, int age, String email, String phoneNumber, String department)
            throws InvalidNameException, InvalidAgeException {
        super(name, age, email, phoneNumber, generateId(name));
        validateName(name);
        validateAge(age);
        this.department = department;
        this.coursesTaught = new ArrayList<>();
    }

    private static String generateId(String name) {
        String safeName = (name == null) ? "" : name.replaceAll("\\s+", "").toUpperCase();
        return "TCH-" + safeName;
    }

    private static void validateName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Teacher name cannot be null or empty");
        }
    }

    private static void validateAge(int age) throws InvalidAgeException {
        if (age <= 0 || age > 120) {
            throw new InvalidAgeException("Teacher age must be between 1 and 120, got: " + age);
        }
    }

    public String getDepartment() { return department; }
    public List<String> getCoursesTaught() { return coursesTaught; }

    public void assignCourse(String courseName) {
        if (!coursesTaught.contains(courseName)) {
            coursesTaught.add(courseName);
        }
    }

    @Override
    public boolean matchesSearch(String query) {
        String q = query.toLowerCase();
        return name.toLowerCase().contains(q) || department.toLowerCase().contains(q);
    }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public void displayInfo() {
        System.out.printf("%s [ID=%s, Name=%s, Age=%d, Department=%s]%n",
                getRole(), id, name, age, department);
    }

    @Override
    public String toString() {
        return super.toString() + ", Department=" + department;
    }
}
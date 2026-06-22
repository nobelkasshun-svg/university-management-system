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
        this.department = department;
        this.coursesTaught = new ArrayList<>();
    }

    private static String generateId(String name) {
        String safeName = (name == null) ? "" : name.replaceAll("\\s+", "").toUpperCase();
        return "TCH-" + safeName;
    }

    public String getDepartment()          { return department; }
    public List<String> getCoursesTaught() { return coursesTaught; }

    public void assignCourse(String courseName) {
        if (!coursesTaught.contains(courseName)) {
            coursesTaught.add(courseName);
        }
    }

    @Override
    public boolean matchesSearch(String query) {
        String q = query.toLowerCase();
        return name.toLowerCase().contains(q)
                || department.toLowerCase().contains(q);
    }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public void displayInfo() {
        System.out.printf("%s [ID=%s, Name=%s, Age=%d, Department=%s]%n",
                getRole(), id, name, age, department);
    }

    public void displayInfo(boolean detailed) {
        displayInfo();
        if (detailed) {
            System.out.println("   Email      : " + email);
            System.out.println("   Phone      : " + phoneNumber);
            System.out.println("   Courses    : " + coursesTaught);
            // ─── Validatable output ───
            System.out.println("   Valid      : " + isValid());
            System.out.println("   Validation : " + getValidationSummary());
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Department=" + department;
    }
}
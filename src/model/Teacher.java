package model;

import interfaces.Searchable;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements Searchable {

    protected String department;
    private List<String> coursesTaught;

    public Teacher(String name, int age, String email, String phoneNumber, String department) {
        super(name, age, email, phoneNumber, "TCH-" + name.replaceAll("\\s+", "").toUpperCase());
        this.department = department;
        this.coursesTaught = new ArrayList<>();
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
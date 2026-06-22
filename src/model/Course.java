package model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseCode;
    private String courseName;
    private int credits;
    private String description;
    private Teacher teacher;
    private List<Student> students;

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.description = "";
        this.students = new ArrayList<>();
    }

    public Course(String courseCode, String courseName, int credits, String description) {
        this(courseCode, courseName, credits);
        this.description = description;
    }

    // ─── Getters ────────────────────────────────────────────
    public String getCourseCode()      { return courseCode; }
    public String getCourseName()      { return courseName; }
    public int getCredits()            { return credits; }
    public String getDescription()     { return description; }
    public Teacher getTeacher()        { return teacher; }
    public List<Student> getStudents() { return students; }

    // ─── Setters ────────────────────────────────────────────
    public void setTeacher(Teacher teacher)        { this.teacher = teacher; }
    public void setDescription(String description) { this.description = description; }
    public void setCredits(int credits)            { this.credits = credits; }

    // ─── Student Management ─────────────────────────────────
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Student '" + student.getName()
                    + "' enrolled in " + courseName);
        } else {
            System.out.println("Student '" + student.getName()
                    + "' is already enrolled in " + courseName);
        }
    }

    public void removeStudent(Student student) {
        if (students.remove(student)) {
            System.out.println("Student '" + student.getName()
                    + "' removed from " + courseName);
        } else {
            System.out.println("Student '" + student.getName()
                    + "' not found in " + courseName);
        }
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    // ─── Display ────────────────────────────────────────────
    public void displayInfo() {
        System.out.println("═".repeat(55));
        System.out.println("Course Code : " + courseCode);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credits     : " + credits);
        System.out.println("Description : " + description);
        System.out.println("Teacher     : " + (teacher != null ? teacher.getName() : "Unassigned"));
        System.out.println("Enrolled Students: " + students.size());
        System.out.println("═".repeat(55));
    }
}
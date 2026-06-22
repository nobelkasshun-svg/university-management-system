package model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentCode;
    private String departmentName;
    private Teacher head;                // head of department — uses your Teacher.java
    private List<Teacher> teachers;      // uses your Teacher.java
    private List<Course> courses;        // uses your Course.java

    public Department(String departmentCode, String departmentName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.head = null;
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // ─── Getters ────────────────────────────────────────────
    public String getDepartmentCode() { return departmentCode; }
    public String getDepartmentName() { return departmentName; }
    public Teacher getHead()          { return head; }
    public List<Teacher> getTeachers(){ return teachers; }
    public List<Course> getCourses()  { return courses; }

    // ─── Head of Department ─────────────────────────────────
    public void setHead(Teacher teacher) {
        // head must be a teacher in this department
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
        }
        this.head = teacher;
    }

    // ─── Teacher Management ─────────────────────────────────
    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            System.out.println("Teacher '" + teacher.getName()
                    + "' added to " + departmentName + " department.");
        } else {
            System.out.println("Teacher '" + teacher.getName()
                    + "' is already in this department.");
        }
    }

    public void removeTeacher(Teacher teacher) {
        if (teachers.remove(teacher)) {
            // if removed teacher was head, clear head
            if (head != null && head.equals(teacher)) {
                head = null;
                System.out.println("Warning: Head of department removed. Please assign a new head.");
            }
            System.out.println("Teacher '" + teacher.getName() + "' removed from department.");
        } else {
            System.out.println("Teacher '" + teacher.getName() + "' not found in department.");
        }
    }

    public boolean hasTeacher(Teacher teacher) {
        return teachers.contains(teacher);
    }

    // ─── Course Management ──────────────────────────────────
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course '" + course.getCourseName()
                    + "' added to " + departmentName + " department.");
        } else {
            System.out.println("Course '" + course.getCourseName()
                    + "' is already in this department.");
        }
    }

    public void removeCourse(Course course) {
        if (courses.remove(course)) {
            System.out.println("Course '" + course.getCourseName() + "' removed from department.");
        } else {
            System.out.println("Course '" + course.getCourseName() + "' not found in department.");
        }
    }

    public boolean hasCourse(Course course) {
        return courses.contains(course);
    }

    // ─── Display ────────────────────────────────────────────
    public void displayInfo() {
        System.out.println("═".repeat(55));
        System.out.println("Department  : " + departmentName + " [" + departmentCode + "]");
        System.out.println("Head        : " + (head != null ? head.getName() : "Not Assigned"));
        System.out.println("Teachers    : " + teachers.size());
        System.out.println("Courses     : " + courses.size());
        System.out.println("═".repeat(55));
    }

    public void displayDetailed() {
        displayInfo();
        System.out.println("── Teachers ──");
        if (teachers.isEmpty()) {
            System.out.println("   No teachers assigned.");
        } else {
            teachers.forEach(t -> System.out.println("   - " + t.getName()
                    + " [" + t.getId() + "]"));
        }
        System.out.println("── Courses ──");
        if (courses.isEmpty()) {
            System.out.println("   No courses assigned.");
        } else {
            courses.forEach(c -> System.out.println("   - " + c.getCourseCode()
                    + " : " + c.getCourseName()
                    + " (" + c.getCredits() + " credits)"));
        }
    }

    @Override
    public String toString() {
        return "Department [" + departmentCode + " - " + departmentName
                + ", Head=" + (head != null ? head.getName() : "None")
                + ", Teachers=" + teachers.size()
                + ", Courses=" + courses.size() + "]";
    }
}

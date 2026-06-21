package database;

import model.Course;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class UniversityService {

    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    public UniversityService() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void printAllStudents() {
        System.out.println("---- Students ----");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void printAllTeachers() {
        System.out.println("---- Teachers ----");
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    public void printAllCourses() {
        System.out.println("---- Courses ----");
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}
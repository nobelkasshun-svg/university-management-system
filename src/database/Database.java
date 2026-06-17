package database;

import model.Student;
import model.Teacher;
import java.util.ArrayList;

public class Database {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("Teacher added: " + teacher.getName());
    }

    public void showAllStudents() {
        System.out.println("--- All Students ---");
        for (Student s : students) {
            s.displayInfo();
        }
    }

    public void showAllTeachers() {
        System.out.println("--- All Teachers ---");
        for (Teacher t : teachers) {
            t.displayInfo();
        }
    }
}

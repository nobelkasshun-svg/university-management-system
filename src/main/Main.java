package main;

import model.Student;
import model.Teacher;
import database.Database;

public class Main {
    public static void main(String[] args) {

        // Member 1 - Inheritance
        Student s1 = new Student("Abel", 20, "STU001");
        Student s2 = new Student("Sara", 22, "STU002");
        Teacher t1 = new Teacher("Dr. John", 45, "Math");

        s1.displayInfo();
        s2.displayInfo();
        t1.displayInfo();

        // Member 5 - Database
        Database db = new Database();
        db.addStudent(s1);
        db.addStudent(s2);
        db.addTeacher(t1);
        db.showAllStudents();
        db.showAllTeachers();
    }
}
package main;

import model.Student;
import model.Teacher;
import database.Database;
import exceptions.GradeChecker;
import exceptions.InvalidGradeException;

public class Main {
    public static void main(String[] args) {

        try {
            // Member 1 - Inheritance with email, phone and GPA
            Student s1 = new Student("Abel Tesfaye", 20, "abel@uni.com", "0911111111", "STU001", "Computer Science", 3.5);
            Student s2 = new Student("Sara Kebede", 22, "sara@uni.com", "0922222222", "STU002", "Software Engineering", 1.8);
            Teacher t1 = new Teacher("Dr. John", 45, "john@uni.com", "0933333333", "Math");

            // Display student info
            System.out.println("--- Student Info ---");
            s1.displayInfo();
            System.out.println();
            s2.displayInfo();
            System.out.println();

            // Display teacher info
            System.out.println("--- Teacher Info ---");
            t1.displayInfo();
            System.out.println();

            // Member 1 - isAdult()
            System.out.println("--- Adult Check ---");
            System.out.println(s1.name + " is adult: " + s1.isAdult());
            System.out.println(s2.name + " is adult: " + s2.isAdult());
            System.out.println();

            // Member 1 - GPA Check
            System.out.println("--- GPA Check ---");
            System.out.println(s1.name + " passing: " + s1.isPassingGPA());
            System.out.println(s2.name + " passing: " + s2.isPassingGPA());
            System.out.println();

            // Member 1 - toString()
            System.out.println("--- toString() ---");
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(t1);
            System.out.println();

            // Member 1 - Overloading
            System.out.println("--- Overloading displayInfo ---");
            s1.displayInfo(true);
            System.out.println();

            // Member 1 - Polymorphism
            System.out.println("--- Polymorphism Demo ---");
            model.Person[] people = {s1, s2, t1};
            for (model.Person p : people) {
                p.displayInfo();
                System.out.println("Role: " + p.getRole());
                System.out.println();
            }

            // Member 1 - Contact Info
            System.out.println("--- Contact Info ---");
            System.out.println(s1.name + " Email: " + s1.email + " Phone: " + s1.phoneNumber);
            System.out.println(s2.name + " Email: " + s2.email + " Phone: " + s2.phoneNumber);
            System.out.println(t1.name + " Email: " + t1.email + " Phone: " + t1.phoneNumber);
            System.out.println();

            // Member 3 - Exceptions
            GradeChecker checker = new GradeChecker();
            try {
                checker.checkGrade(95);
                checker.checkGrade(150);
            } catch (InvalidGradeException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }

            // Member 5 - Database
            Database db = new Database();
            db.addStudent(s1);
            db.addStudent(s2);
            db.addTeacher(t1);
            db.showAllStudents();
            db.showAllTeachers();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
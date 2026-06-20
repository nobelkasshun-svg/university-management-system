package main;

import model.Student;
import model.Teacher;
import database.Database;
import exceptions.GradeChecker;
import exceptions.InvalidGradeException;

public class Main {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("Abel Tesfaye", 20, "abel@uni.com", "0911111111", "STU001", "Computer Science", 3.5);
            Student s2 = new Student("Sara Kebede", 22, "sara@uni.com", "0922222222", "STU002", "Software Engineering", 1.8);
            Teacher t1 = new Teacher("Dr. John", 45, "john@uni.com", "0933333333", "Math");

            System.out.println("--- Student Info ---");
            s1.displayInfo();
            System.out.println();
            s2.displayInfo();
            System.out.println();

            System.out.println("--- Teacher Info ---");
            t1.displayInfo();
            System.out.println();

            System.out.println("--- Adult Check ---");
            System.out.println(s1.getName() + " is adult: " + s1.isAdult());
            System.out.println(s2.getName() + " is adult: " + s2.isAdult());
            System.out.println();

            System.out.println("--- GPA Check ---");
            System.out.println(s1.getName() + " passing: " + s1.isPassingGPA());
            System.out.println(s2.getName() + " passing: " + s2.isPassingGPA());
            System.out.println();

            System.out.println("--- toString() ---");
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(t1);
            System.out.println();

            System.out.println("--- Overloading displayInfo ---");
            s1.displayInfo(true);
            System.out.println();

            System.out.println("--- Polymorphism Demo ---");
            model.Person[] people = {s1, s2, t1};
            for (model.Person p : people) {
                p.displayInfo();
                System.out.println("Role: " + p.getRole());
                System.out.println();
            }

            System.out.println("--- Contact Info ---");
            System.out.println(s1.getName() + " Email: " + s1.getEmail() + " Phone: " + s1.getPhoneNumber());
            System.out.println(s2.getName() + " Email: " + s2.getEmail() + " Phone: " + s2.getPhoneNumber());
            System.out.println(t1.getName() + " Email: " + t1.getEmail() + " Phone: " + t1.getPhoneNumber());
            System.out.println();

            GradeChecker checker = new GradeChecker();
            try {
                checker.checkGrade(95);
                checker.checkGrade(150);
            } catch (InvalidGradeException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
            System.out.println();

            Database db = new Database();
            db.addStudent(s1);
            db.addStudent(s2);
            db.addTeacher(t1);
            db.showAllStudents();
            db.showAllTeachers();
            System.out.println();

            System.out.println("--- Test: Searchable ---");
            Student s5 = new Student("Luna Lovegood", 19, "luna@university.edu", "+251911000005", "UGR/0500/24");
            s5.enroll("Defense Against the Dark Arts");

            System.out.println("Search 'Luna':");
            System.out.println("  Student matches: " + s5.matchesSearch("Luna"));
            System.out.println("  Teacher matches: " + t1.matchesSearch("Luna"));

            System.out.println("\nSearch 'Software':");
            System.out.println("  Student matches: " + s5.matchesSearch("Software"));
            System.out.println("  Teacher matches: " + t1.matchesSearch("Software"));

            System.out.println("\nSearch 'UGR/0500/24':");
            System.out.println("  Student matches: " + s5.matchesSearch("UGR/0500/24"));

            System.out.println("\nSearch 'Defense':");
            System.out.println("  Student matches: " + s5.matchesSearch("Defense"));

            System.out.println("\n===== All Tests Completed =====");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
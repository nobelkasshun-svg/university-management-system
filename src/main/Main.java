package main;

import model.Student;
import model.Teacher;
<<<<<<< HEAD
import database.Database;
import exceptions.GradeChecker;
import exceptions.InvalidGradeException;
=======
import interfaces.Enrollable;
import interfaces.Printable;
import interfaces.Searchable;
>>>>>>> cfcfcda1c6d50f078f10dac34df8607674397754

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

<<<<<<< HEAD
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
=======
        System.out.println("\n--- Test 10: Searchable ---");
        try {
            Student s5 = new Student("Luna Lovegood", 19, "UGR/0500/24", "+251911000005", "luna@university.edu");
            s5.enroll("Defense Against the Dark Arts");
            
            Teacher t1 = new Teacher("Dr. Hailu Mersha", 45, "Software Engineering", "+251922000001", "hailu@university.edu");
            
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
        } catch (UniversityException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n===== All Tests Completed =====");
>>>>>>> cfcfcda1c6d50f078f10dac34df8607674397754
    }
}
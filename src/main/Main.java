package main;

import exceptions.*;
import model.Student;
import model.Teacher;
import database.UniversityService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniversityService service = new UniversityService();
        boolean running = true;

        System.out.println("===== University Management System =====");

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent(scanner, service);
                    break;
                case "2":
                    addTeacher(scanner, service);
                    break;
                case "3":
                    service.printAllStudents();
                    break;
                case "4":
                    service.printAllTeachers();
                    break;
                case "5":
                    searchStudents(scanner, service);
                    break;
                case "6":
                    enrollStudent(scanner, service);
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.println("3. View All Students");
        System.out.println("4. View All Teachers");
        System.out.println("5. Search Students");
        System.out.println("6. Enroll Student in Course");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    static void addStudent(Scanner scanner, UniversityService service) {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Student ID: ");
            String id = scanner.nextLine();
            System.out.print("Major: ");
            String major = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            Student student = new Student(name, age, email, phone, id, major, gpa);
            service.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: please enter valid numbers for age and GPA.");
        }
    }

    static void addTeacher(Scanner scanner, UniversityService service) {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            Teacher teacher = new Teacher(name, age, email, phone, department);
            service.addTeacher(teacher);
            System.out.println("Teacher added successfully!");
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: please enter a valid number for age.");
        }
    }

    static void searchStudents(Scanner scanner, UniversityService service) {
        System.out.print("Enter search keyword: ");
        String query = scanner.nextLine();
        List<Student> students = service.getStudents();

        boolean found = false;
        for (Student s : students) {
            if (s.matchesSearch(query)) {
                s.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students matched your search.");
        }
    }

    static void enrollStudent(Scanner scanner, UniversityService service) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        Student target = null;

        for (Student s : service.getStudents()) {
            if (s.getId().equalsIgnoreCase(id)) {
                target = s;
                break;
            }
        }

        if (target == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course name to enroll: ");
        String course = scanner.nextLine();
        target.enroll(course);
        System.out.println("Enrolled " + target.getName() + " in " + course);
    }
}
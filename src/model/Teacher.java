package model;

public class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String email, String phoneNumber, String subject) {
        super(name, age, email, phoneNumber);
        this.subject = subject;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }

    public String getRole() {
        return "Teacher";
    }
}
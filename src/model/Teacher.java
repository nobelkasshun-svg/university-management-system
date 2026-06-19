package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidSubjectException;

public class Teacher extends Person {
    public String subject;

    public Teacher(String name, int age, String email, String phoneNumber, String subject)
            throws InvalidNameException, InvalidAgeException, InvalidSubjectException {
        super(name, age, email, phoneNumber);
        if (subject == null || subject.trim().isEmpty()) {
            throw new InvalidSubjectException(subject);
        }
        this.subject = subject.trim();
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }

    @Override
    public String toString() {
        return super.toString() + " | Subject: " + subject;
    }

    public String getRole() {
        return "Teacher";
    }
}
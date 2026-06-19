package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidSubjectException;
import interfaces.Printable;

public class Teacher extends Person implements Printable {
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
    public void printDetails() {
        displayInfo();
    }

    @Override
    public boolean matchesSearch(String keyword) {
        if (super.matchesSearch(keyword)) {
            return true;
        }
        if (keyword == null || keyword.trim().isEmpty()) {
            return false;
        }
        String kw = keyword.toLowerCase().trim();
        return subject.toLowerCase().contains(kw);
    }

    @Override
    public String toString() {
        return super.toString() + " | Subject: " + subject;
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}
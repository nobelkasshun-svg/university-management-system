package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidSubjectException;

public class Teacher extends Person {
    public String subject;

    public Teacher(String name, int age, String subject, String phoneNumber, String email)
            throws InvalidNameException, InvalidAgeException, InvalidSubjectException {
        super(name, age, phoneNumber, email);
        if (subject == null || subject.trim().isEmpty()) {
            throw new InvalidSubjectException(subject);
        }
        this.subject = subject.trim();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}
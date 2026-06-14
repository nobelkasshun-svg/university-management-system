package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import exceptions.InvalidSubjectException;

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject)
            throws InvalidNameException, InvalidAgeException, InvalidSubjectException {
        super(name, age);
        setSubject(subject);
    }

    public void setSubject(String subject) throws InvalidSubjectException {
        if (subject == null || subject.trim().isEmpty()) {
            throw new InvalidSubjectException(subject);
        }
        this.subject = subject.trim();
    }

    public String getSubject() { return subject; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}

package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;

public class Person {
    public String name;
    public int age;
    private String phoneNumber;
    private String email;

    public Person(String name, int age, String phoneNumber, String email)
            throws InvalidNameException, InvalidAgeException {
        setName(name);
        setAge(age);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public void setName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException(name, "Name cannot be null or empty");
        }
        if (!name.matches("[a-zA-Z .]+")) {
            throw new InvalidNameException(name, "Name can only contain letters and spaces");
        }
        this.name = name.trim();
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age <= 0 || age > 120) {
            throw new InvalidAgeException(age);
        }
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        this.phoneNumber = phoneNumber.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }
        this.email = email.trim();
    }

    public String getName()        { return name; }
    public int getAge()            { return age; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail()       { return email; }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
        System.out.println("Phone: " + phoneNumber + ", Email: " + email);
    }
}
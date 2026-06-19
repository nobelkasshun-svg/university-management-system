package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;

public abstract class Person {
    public String name;
    public int age;
    public String email;
    public String phoneNumber;

    public Person(String name, int age, String email, String phoneNumber) throws InvalidNameException, InvalidAgeException {
        setName(name);
        setAge(age);
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    public abstract String getRole();

    // toString() in Person
    @Override
    public String toString() {
        return "Name: " + name + " | Age: " + age + " | Email: " + email + " | Phone: " + phoneNumber;
    }
}
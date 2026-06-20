package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;

public abstract class Person {
    protected String id;
    protected String name;
    protected int age;
    protected String email;
    protected String phoneNumber;

    public Person(String name, int age, String email, String phoneNumber, String id) throws InvalidNameException, InvalidAgeException {
        setName(name);
        setAge(age);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
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

    public boolean isAdult() {
        return age >= 18;
    }

    // returns all info as one clean string
    public String getFullInfo() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email + ", Phone: " + phoneNumber + ", Adult: " + isAdult();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    public abstract String getRole();

    public void displayInfo() {
        System.out.println(getRole() + " [ID=" + id + ", Name=" + name + ", Age=" + age
                + ", Email=" + email + ", Phone=" + phoneNumber + ", Adult=" + isAdult() + "]");
    }

    @Override
    public String toString() {
        return getRole() + " [ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}
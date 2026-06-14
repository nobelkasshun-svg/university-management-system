package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;

public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) throws InvalidNameException, InvalidAgeException {
        setName(name);
        setAge(age);
    }

    public void setName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException(name, "Name cannot be null or empty");
        }
        if (!name.matches("[a-zA-Z ]+")) {
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

    public String getName() { return name; }
    public int getAge()     { return age; }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

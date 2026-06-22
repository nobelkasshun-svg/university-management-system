package model;

import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import interfaces.Validator;

public abstract class Person implements Validator {

    protected String id;
    protected String name;
    protected int age;
    protected String email;
    protected String phoneNumber;

    public Person(String name, int age, String email, String phoneNumber, String id)
            throws InvalidNameException, InvalidAgeException {
        setName(name);
        setAge(age);
        setEmail(email);
        setPhoneNumber(phoneNumber);
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

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain '@'.");
        }
        this.email = email.trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        this.phoneNumber = phoneNumber.trim();
    }

    @Override
    public boolean isValid() {
        return name != null && !name.trim().isEmpty()
                && age > 0 && age <= 120
                && email != null && !email.trim().isEmpty()
                && phoneNumber != null && !phoneNumber.trim().isEmpty()
                && id != null && !id.trim().isEmpty();
    }

    @Override
    public String getValidationSummary() {
        return "Name  : " + (name != null && !name.trim().isEmpty() ? "OK" : "INVALID")
             + " | Age   : " + (age > 0 && age <= 120 ? "OK" : "INVALID")
             + " | Email : " + (email != null && !email.trim().isEmpty() ? "OK" : "INVALID")
             + " | Phone : " + (phoneNumber != null && !phoneNumber.trim().isEmpty() ? "OK" : "INVALID")
             + " | ID    : " + (id != null && !id.trim().isEmpty() ? "OK" : "INVALID");
    }

    public boolean isAdult() { return age >= 18; }

    public String getFullInfo() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email
                + ", Phone: " + phoneNumber + ", Adult: " + isAdult();
    }

    public String getId()          { return id; }
    public String getName()        { return name; }
    public int getAge()            { return age; }
    public String getEmail()       { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    public abstract String getRole();

    public void displayInfo() {
        System.out.println(getRole() + " [ID=" + id + ", Name=" + name + ", Age=" + age
                + ", Email=" + email + ", Phone=" + phoneNumber
                + ", Adult=" + isAdult() + "]");
    }

    @Override
    public String toString() {
        return getRole() + " [ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}

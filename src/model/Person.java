package model;

public abstract class Person {
    protected String id;
    protected String name;
    protected int age;
    protected String email;
    protected String phoneNumber;

    public Person(String name, int age, String email, String phoneNumber, String id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    public abstract String getRole();

    public void displayInfo() {
        System.out.println(getRole() + " [ID=" + id + ", Name=" + name + ", Age=" + age
                + ", Email=" + email + ", Phone=" + phoneNumber + "]");
    }

    @Override
    public String toString() {
        return getRole() + " [ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}
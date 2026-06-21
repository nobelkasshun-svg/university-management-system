package model;

import exceptions.InvalidNameException;
import exceptions.InvalidAgeException;

public class GraduateStudent extends Student {

    public enum DegreeLevel {
        MASTERS, PHD
    }

    private String thesisTitle;
    private Teacher advisor;
    private DegreeLevel degreeLevel;

    // Full constructor
    public GraduateStudent(String name, int age, String email, String phoneNumber,
                           String id, String major, double gpa, DegreeLevel degreeLevel) throws InvalidNameException, InvalidAgeException {
        super(name, age, email, phoneNumber, id, major, gpa);
        this.degreeLevel = degreeLevel;
        this.thesisTitle = "Undeclared";
        this.advisor = null;
    }

    // Short constructor (no thesis/advisor yet)
    public GraduateStudent(String name, int age, String email, String phoneNumber,
                           String id, DegreeLevel degreeLevel) throws InvalidNameException, InvalidAgeException {
        this(name, age, email, phoneNumber, id, "Undeclared", 0.0, degreeLevel);
    }

    // Getters
    public String getThesisTitle() { return thesisTitle; }
    public Teacher getAdvisor() { return advisor; }
    public DegreeLevel getDegreeLevel() { return degreeLevel; }

    // Setters
    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }
    public void setAdvisor(Teacher advisor) { this.advisor = advisor; }

    @Override
    public String getRole() {
        return degreeLevel == DegreeLevel.PHD ? "PhD Student" : "Masters Student";
    }

    @Override
    public void displayInfo() {
        System.out.printf("%s [ID=%s, Name=%s, Age=%d, Major=%s, GPA=%.2f]%n",
                getRole(), id, name, age, major, gpa);
    }

    @Override
    public void displayInfo(boolean detailed) {
        displayInfo();
        if (detailed) {
            System.out.println("   Email    : " + email);
            System.out.println("   Phone    : " + phoneNumber);
            System.out.println("   Degree   : " + degreeLevel);
            System.out.println("   Thesis   : " + thesisTitle);
            System.out.println("   Advisor  : " + (advisor != null ? advisor.getName() : "Unassigned"));
            System.out.println("   Courses  : " + enrolledCourses);
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Degree=" + degreeLevel
                + ", Thesis=" + thesisTitle
                + ", Advisor=" + (advisor != null ? advisor.getName() : "None");
    }
}
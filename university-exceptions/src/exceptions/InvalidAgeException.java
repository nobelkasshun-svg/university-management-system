package exceptions;

public class InvalidAgeException extends UniversityException {

    private int invalidAge;

    public InvalidAgeException(int age) {
        super("Invalid age: " + age + ". Age must be between 1 and 120.", "INVALID_AGE");
        this.invalidAge = age;
    }

    public InvalidAgeException(String message) {
        super(message, "INVALID_AGE");
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}

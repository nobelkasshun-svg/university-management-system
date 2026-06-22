package exceptions;

public class InvalidAgeException extends Exception {
    private int invalidAge;

    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException(int invalidAge) {
        super("Invalid age: " + invalidAge + ". Age must be between 1 and 120.");
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}
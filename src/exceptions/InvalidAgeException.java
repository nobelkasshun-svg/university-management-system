package exceptions;

public class InvalidAgeException extends Exception {

    public InvalidAgeException(int invalidAge) {
        super("Invalid age: " + invalidAge + ". Age must be between 1 and 120.");
    }
}
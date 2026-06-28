package exceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException(String invalidName, String reason) {
        super("Invalid name '" + invalidName + "': " + reason);
    }
}

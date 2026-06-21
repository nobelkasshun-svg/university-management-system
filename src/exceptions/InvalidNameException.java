package exceptions;

public class InvalidNameException extends Exception {
    private String invalidName;

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(String invalidName, String message) {
        super(message);
        this.invalidName = invalidName;
    }

    public String getInvalidName() {
        return invalidName;
    }
}
package exceptions;

public class InvalidNameException extends UniversityException {

    private String invalidName;

    public InvalidNameException(String name) {
        super("Invalid name: '" + name + "'. Name cannot be null or empty.", "INVALID_NAME");
        this.invalidName = name;
    }

    public InvalidNameException(String name, String reason) {
        super("Invalid name: '" + name + "'. Reason: " + reason, "INVALID_NAME");
        this.invalidName = name;
    }

    public String getInvalidName() {
        return invalidName;
    }
}

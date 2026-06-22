package exceptions;

public class InvalidAgeException extends Exception {
<<<<<<< HEAD

    public InvalidAgeException(int invalidAge) {
        super("Invalid age: " + invalidAge + ". Age must be between 1 and 120.");
=======
    private int invalidAge;

    public InvalidAgeException(String message) {
        super(message);
>>>>>>> ed5ad2ff126d5636ede6894dc40e8b717ca6ff3c
    }

    public InvalidAgeException(int invalidAge) {
        super("Invalid age: " + invalidAge);
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() {
        return invalidAge;
    }
}
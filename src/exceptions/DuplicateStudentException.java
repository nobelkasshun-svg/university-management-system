package exceptions;

public class DuplicateStudentException extends Exception {
    public DuplicateStudentException(String studentId) {
        super("A student with ID " + studentId + " is already registered");
    }
}
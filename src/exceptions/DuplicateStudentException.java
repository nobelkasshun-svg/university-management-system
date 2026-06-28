package exceptions;

public class DuplicateStudentException extends Exception {
    private final String duplicateId;

    public DuplicateStudentException(String studentId) {
        super("A student with ID " + studentId + " is already registered");
        this.duplicateId = studentId;
    }

    public String getDuplicateId() {
        return duplicateId;
    }
}

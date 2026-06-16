package exceptions;

public class DuplicateStudentException extends UniversityException {

    private String duplicateId;

    public DuplicateStudentException(String studentId) {
        super("A student with ID '" + studentId + "' already exists in the system.", "DUPLICATE_STUDENT");
        this.duplicateId = studentId;
    }

    public String getDuplicateId() {
        return duplicateId;
    }
}

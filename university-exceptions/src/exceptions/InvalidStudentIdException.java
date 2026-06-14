package exceptions;

public class InvalidStudentIdException extends UniversityException {

    private String invalidId;

    public InvalidStudentIdException(String studentId) {
        super("Invalid student ID: '" + studentId + "'. ID cannot be null or empty.", "INVALID_STUDENT_ID");
        this.invalidId = studentId;
    }

    public InvalidStudentIdException(String studentId, String reason) {
        super("Invalid student ID: '" + studentId + "'. Reason: " + reason, "INVALID_STUDENT_ID");
        this.invalidId = studentId;
    }

    public String getInvalidId() {
        return invalidId;
    }
}

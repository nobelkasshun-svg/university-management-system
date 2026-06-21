package exceptions;

public class StudentNotFoundException extends Exception {
    private final String errorCode;

    public StudentNotFoundException(String studentId) {
        super("No student found with ID: " + studentId);
        this.errorCode = "ERR_STUDENT_NOT_FOUND";
    }

    public String getErrorCode() {
        return errorCode;
    }
}
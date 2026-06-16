package exceptions;

public class UniversityException extends Exception {

    private String errorCode;

    public UniversityException(String message) {
        super(message);
        this.errorCode = "UNI_ERROR";
    }

    public UniversityException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public UniversityException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "UNI_ERROR";
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "[" + errorCode + "] " + getMessage();
    }
}

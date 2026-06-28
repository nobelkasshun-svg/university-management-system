package exceptions;

public class InvalidSubjectException extends UniversityException {
    private String invalidSubject;

    public InvalidSubjectException(String subject) {
        super("Invalid subject: '" + subject + "'. Subject cannot be null or empty.", "INVALID_SUBJECT");
        this.invalidSubject = subject;
    }

    public String getInvalidSubject() {
        return invalidSubject;
    }
}

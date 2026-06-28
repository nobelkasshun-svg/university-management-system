package exceptions;

public class InvalidGradeException extends Exception {
    private final double invalidGrade;

    public InvalidGradeException(String message) {
        super(message);
        this.invalidGrade = -1;
    }

    public InvalidGradeException(double grade) {
        super("Invalid grade: " + grade + ". Must be between 0 and 100.");
        this.invalidGrade = grade;
    }

    public double getInvalidGrade() { return invalidGrade; }
}

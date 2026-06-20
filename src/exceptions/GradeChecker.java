package exceptions;

public class GradeChecker {
    public void checkGrade(double grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Invalid grade: " + grade + ". Grade must be between 0 and 100.");
        }
    }
}
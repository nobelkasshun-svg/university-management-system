package exceptions;

public class StudentNotFoundException extends UniversityException {

    private String searchedId;

    public StudentNotFoundException(String studentId) {
        super("Student not found with ID: '" + studentId + "'.", "STUDENT_NOT_FOUND");
        this.searchedId = studentId;
    }

    public String getSearchedId() {
        return searchedId;
    }
}

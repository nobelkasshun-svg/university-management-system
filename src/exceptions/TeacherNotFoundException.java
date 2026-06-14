package exceptions;

public class TeacherNotFoundException extends UniversityException {

    private String searchedName;

    public TeacherNotFoundException(String teacherName) {
        super("Teacher not found with name: '" + teacherName + "'.", "TEACHER_NOT_FOUND");
        this.searchedName = teacherName;
    }

    public String getSearchedName() {
        return searchedName;
    }
}

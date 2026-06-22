package model;

public class Grade {

    private Student student;

    private Course course;

    private double score;

    private LetterGrade letterGrade;

    private String semester;



    public Grade(Student student, Course course, double score, String semester) {

        this.student = student;

        this.course = course;

        this.score = score;

        this.semester = semester;

        this.letterGrade = calculateLetterGrade(score);

    }



    private LetterGrade calculateLetterGrade(double score) {

        if (score >= 97)      return LetterGrade.A_PLUS;

        else if (score >= 93) return LetterGrade.A;

        else if (score >= 90) return LetterGrade.A_MINUS;

        else if (score >= 87) return LetterGrade.B_PLUS;

        else if (score >= 83) return LetterGrade.B;

        else if (score >= 80) return LetterGrade.B_MINUS;

        else if (score >= 77) return LetterGrade.C_PLUS;

        else if (score >= 73) return LetterGrade.C;

        else if (score >= 70) return LetterGrade.C_MINUS;

        else if (score >= 60) return LetterGrade.D;

        else                  return LetterGrade.F;

    }



    // Getters

    public Student getStudent()       { return student; }

    public Course getCourse()         { return course; }

    public double getScore()          { return score; }

    public LetterGrade getLetterGrade() { return letterGrade; }

    public String getSemester()       { return semester; }



    // Update score and recalculate letter grade automatically

    public void setScore(double score) {

        this.score = score;

        this.letterGrade = calculateLetterGrade(score);

    }



    public boolean isPassing() {

        return score >= 60;

    }

    public static boolean isPassingScore(double score) {

        return score >= 0 && score <= 100 && score >= 60;

    }

    public static boolean isValidScore(double score) {

        return score >= 0 && score <= 100;

    }



    public void displayGrade() {

        System.out.printf("Student: %-20s | Course: %-15s [%s] | Score: %5.1f | Grade: %-8s | Semester: %s%n",

                student.getName(),

                course.getCourseName(),

                course.getCourseCode(),

                score,

                letterGrade,

                semester);

    }



    @Override

    public String toString() {

        return "Grade [Student=" + student.getName()

                + ", Course=" + course.getCourseCode()

                + " - " + course.getCourseName()

                + ", Score=" + score

                + ", Grade=" + letterGrade

                + ", Semester=" + semester + "]";

    }

}

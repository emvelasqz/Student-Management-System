public class Grade {
    private final Course course;
    private final Student student;
    private double gradeValue;

    public Grade(Course course, Student student, double gradeValue) {
        this.course = course;
        this.student = student;
        this.gradeValue = gradeValue;
    }

    public double getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }

    public Student getStudent() {
        return student;
    }
}
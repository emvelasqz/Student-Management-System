public class Grade {
    private Course course;
    private double gradeValue;
    private Student student;

    // constructor
    public Grade(Course course, Student student, double gradeValue) {
        this.course = course;
        this.student = student;
        this.gradeValue = gradeValue;
    }

    // metthods (getter)
    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }
    
    public double getGradeValue() {
        return gradeValue;
    }
}
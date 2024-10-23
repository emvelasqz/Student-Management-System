import java.util.ArrayList;
import java.util.List;

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

    // methods (getter)

    public Student getStudent() {
        return student;
    }

    public double getGradeValue() {
        return gradeValue;
    }

    public List<Grade> getGrades() {
        List<Grade> grades = new ArrayList<>();
        for (Course course : courses) {
            grades.add(course.getGradeForStudent(this));
        }
        return grades;
    }

    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }
}
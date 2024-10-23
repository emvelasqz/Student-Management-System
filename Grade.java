import java.util.ArrayList;
import java.util.List;

public class Grade {
    private double gradeValue;
    private Student student;
    protected List<Grade> grades;

    // constructor
    public Grade(Course course, Student student, double gradeValue) {
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

    public Grade getGradeForStudent(Student student) {
        for (Grade grade : grades) {
            if (grade.getStudent().equals(student)) {
                return grade;
            }
        }
        return null;
    }

    public List<Grade> getGrades() {
        List<Grade> grades = new ArrayList<>();
        for (Course course : courses) {
            grades.add(course.getGradeForStudent(this));
        }
        return grades;
    }

    public void assignGrade(Student student, double gradeValue) {
        Grade grade = new Grade(this, student, gradeValue);
        grades.add(grade);
    }

    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }
}
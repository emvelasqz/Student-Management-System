import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private String day;
    private String time;
    private List<Grade> grades;

    // constructor
    public Course(String courseName, String courseCode, String day, String time) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.day = day;
        this.time = time;
        this.grades = new ArrayList<>();
    }

    // a method to attach a grade in the course
    public void assignGrade(Student student, double gradeValue) {
        Grade grade = new Grade(this, student, gradeValue);
        grades.add(grade);
    }

    // to retrieve grade of a student in a course
    public Grade getGradeForStudent(Student student) {
        for (Grade grade : grades) {
            if (grade.getStudent().equals(student)) {
                return grade;
            }
        }
        return null;
    }

    // to display the details of the course
    public String getDetails() {
        return "\nCourse Name: " + courseName + "\nCourse Code: " + courseCode + "\nDay: " + day + ", Time: " + time;
    }
}
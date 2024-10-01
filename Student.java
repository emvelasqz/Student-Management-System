import java.util.ArrayList;
import java.util.List;

public abstract class Student {
    // attributes
    protected String studentID;
    protected String name;
    protected String type; // regular or irregular
    protected List<Course> courses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // methods

    public List<Course> getCourses() {
        return courses;
    }

    public void enroll(Course course) {
        courses.add(course);
    }

    public String getDetails() {
        return "Name: " + name + "\nID: " + studentID + "\nType: " + type;
    }

    public void dropCourse(Course course) {
        courses.remove(course);
    }

    public void dropBlock() {
        courses.clear();
    }

    public List<Grade> getGrades() {
        List<Grade> grades = new ArrayList<>();
        for (Course course : courses) {
            grades.add(course.getGradeForStudent(this));
        }
        return grades;
    }

    public abstract double calculateTotalFees();
}
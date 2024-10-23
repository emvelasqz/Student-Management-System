import java.util.ArrayList;
import java.util.List;

public class Course {
    private Course course;
    protected List<Course> courses;
    protected String courseName;
    protected String courseCode;

    // constructor
    public Course(String courseName, String courseCode, Schedule schedule) {
        this.courses = new ArrayList<>();
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    // methods
    public Course getCourse() {
        return course;
    }

    public List<Course> getCourses() {
        return courses;
    }
    
    public void enroll(Course course) {
        courses.add(course);
    }

    public void dropCourse(Course course) {
        courses.remove(course);
    }

    // to display the details of the course
    public String getDetails() {
        return "\nCourse Name: " + courseName + "\nCourse Code: " + courseCode;
    }
}
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

    public void dropCourse(String courseCode) {
        courses.removeIf(course -> course.getCourseCode().equals(courseCode));
    }

    // getters & setters

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
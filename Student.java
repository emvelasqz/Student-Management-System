import java.util.ArrayList;
import java.util.List;

public abstract class Student {
    protected String studentID;
    protected String name;
    protected String type; // regular or irregular
    protected List<Course> courses;
    
    public Student(String studentID, String name, String type) {
        this.studentID = studentID;
        this.name = name;
        this.type = type; 
        this.courses = new ArrayList<>();
    }
    
    public abstract double calculateTotalFees();
    
    public void enroll(Course course) {
        courses.add(course);
    }
    
    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }
    
    public String getDetails() {
        return "ID: " + studentID + ", Name: " + name + ", Type: " + type;
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
}
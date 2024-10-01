import java.util.ArrayList;
import java.util.List;

public abstract class Student {
    // attributes
    protected String studentID;
    protected String name;
    protected String type; // regular or irregular
    protected List<Course> courses;
    protected double admissionFee;

    public Student(String studentID, String name, String type) {
        this.studentID = studentID;
        this.name = name;
        this.type = type;
        this.courses = new ArrayList<>();
        this.admissionFee = setAdmissionFee(type);
    }

    // methods
    public List<Course> getCourses() {
        return courses;
    }

    public void enroll(Course course) {
        courses.add(course);
    }

    public String getDetails() {
        return "Name: " + name + ", ID: " + studentID + ", Type: " + type + ", Admission Fee: " + admissionFee;
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

    private double setAdmissionFee(String type) {
        if (type.equalsIgnoreCase("Regular")) {
            return 10000.0;
        } else {
            return 10000.0 + 2000.0; 
        }
    }

    public void updateType(String newType) {
        this.type = newType;
        this.admissionFee = setAdmissionFee(newType); // update the fee based on new type
    }

    public double getAdmissionFee() {
        return admissionFee;
    }

    public abstract double calculateTotalFees();
}
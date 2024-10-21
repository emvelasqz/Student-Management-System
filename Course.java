import java.util.ArrayList;
import java.util.List;

public class Course {
    protected List<Course> courses;
    protected String courseName;
    protected String courseCode;
    protected List<Schedule> schedules;
    protected List<Grade> grades;

    // constructor
    public Course(String courseName, String courseCode, Schedule schedule) {
        this.courses = new ArrayList<>();
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.grades = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    // methods
    public List<Course> getCourses() {
        return courses;
    }

    public void enroll(Course course) {
        courses.add(course);
    }

    public void dropCourse(Course course) {
        courses.remove(course);
    }



    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
    
    public void viewSchedules() {
        if (schedules.isEmpty()) {
            System.out.println("No schedules available for this course.");
            return;
        }
        
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getScheduleDetails());
        }
    }

    public void assignGrade(Student student, double gradeValue) {
        Grade grade = new Grade(this, student, gradeValue);
        grades.add(grade);
    }

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
        return "\nCourse Name: " + courseName + "\nCourse Code: " + courseCode;
    }
}
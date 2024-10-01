import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private List<Schedule> schedules;
    private List<Grade> grades;

    // constructor
    public Course(String courseName, String courseCode, Schedule schedule) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.grades = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    // methods
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
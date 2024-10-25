import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String name;
    private String courseCode;
    private List<Schedule> schedules;
    private Map<Student, Grade> grades;
    
    public Course(String name, String courseCode) {
        this.name = name;
        this.courseCode = courseCode;
        this.schedules = new ArrayList<>();
        this.grades = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
    
    public void clearSchedules() {
        schedules.clear();
    }
    
    public void assignGrade(Student student, double gradeValue) {
        Grade grade = new Grade(this, student, gradeValue);
        grades.put(student, grade);
    }
    
    public Grade getGradeForStudent(Student student) {
        return grades.get(student);
    }
    
    public void viewSchedules() {
        if (schedules.isEmpty()) {
            System.out.println("No schedules available");
            return;
        }
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getScheduleDetails());
        }
    }
    
    public String getSchedule() {
        StringBuilder sb = new StringBuilder();
        for (Schedule schedule : schedules) {
            sb.append(schedule.getScheduleDetails()).append("; ");
        }
        return sb.toString();
    }
    
    public String getDetails() {
        return "Course: " + name + " (" + courseCode + ")";
    }
}
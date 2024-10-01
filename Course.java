import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private List<Schedule> schedules;
    private List<Grade> grades;

    // constructor
    public Course(String courseName, String courseCode, String day, String time) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.schedules = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    // methods

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    public void viewSchedules() {
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getScheduleDetails());
        }
    }

    public void updateSchedule(int index, String newDay, String newTime, String newBlock) {
        if (index >= 0 && index < schedules.size()) {
            Schedule schedule = schedules.get(index);
            schedule.updateDay(newDay);
            schedule.updateTime(newTime);
            schedule.updateBlock(newBlock);
        } else {
            System.out.println("Invalid schedule.");
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
        return "\nCourse Name: " + courseName + "\nCourse Code: " + courseCode + "\nDay: " + day + ", Time: " + time;
    }
}
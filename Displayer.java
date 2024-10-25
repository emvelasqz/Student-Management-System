public class Displayer {
    public void displayCourseDetails(Course course) {
        System.out.println(course.getDetails());
        System.out.println("Schedules:");
        course.viewSchedules();
    }

    public void displayStudentDetails(Student student) {
        System.out.println(student.getDetails());
        System.out.println("Courses Enrolled:");
        for (Course course : student.getCourses()) {
            Grade grade = course.getGradeForStudent(student);
            String gradeText = (grade != null) ? String.valueOf(grade.getGradeValue()) : "Not assigned";
            System.out.println(course.getDetails() + " - Grade: " + gradeText);
            System.out.println("Course Schedules:");
            course.viewSchedules();
        }
    }
}
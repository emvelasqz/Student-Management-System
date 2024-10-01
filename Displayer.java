public class Displayer {
    // methods to display in the main class
    public void displayStudentDetails(Student student) {
        System.out.println(student.getDetails());
        
        System.out.println("Enrolled Courses:");
        for (Course course : student.getCourses()) {
            Grade grade = course.getGradeForStudent(student);
            if (grade != null) {
                System.out.println(course.getDetails() + " - Grade: " + grade.getGradeValue());
            } else {
                System.out.println(course.getDetails() + " - Grade: Not assigned");
            }

            System.out.println("Course Schedule:");
            course.viewSchedules();
        }
        System.out.println("Total Amount: " + student.calculateTotalFees());
    }

    public void displayCourseDetails(Course course) {
        System.out.println(course.getDetails());
        System.out.println("Schedules:");
        course.viewSchedules();
    }
}
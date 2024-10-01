import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Displayer displayer = new Displayer();
        Scanner scan = new Scanner(System.in);
        Student student = null;
        Course course = null;

        while (true) { // execution of while loop
            System.out.println("================= Student Management System =================");
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student to Course");
            System.out.println("4. Assign Grade to Student");
            System.out.println("5. View Student Details");
            System.out.println("6. View Course Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    student = inputter.createStudent();
                    System.out.println("Student created successfully!");
                    break;
                case 2:
                    course = inputter.createCourse();
                    System.out.println("Course created successfully!");
                    break;
                case 3:
                    if (student == null || course == null) {
                        System.out.println("Please create a student and a course first!");
                    } else {
                        student.enroll(course);
                        System.out.println("Student enrolled in course successfully!");
                    }
                    break;
                case 4:
                    if (student == null || course == null) {
                        System.out.println("Please create a student and a course first!");
                    } else {
                        double grade = inputter.getGradeInput();
                        course.assignGrade(student, grade);
                        System.out.println("Grade assigned to student successfully!");
                    }
                    break;
                case 5:
                    if (student == null) {
                        System.out.println("Please create a student first!");
                    } else {
                        displayer.displayStudentDetails(student);
                    }
                    break;
                case 6:
                    if (course == null) {
                        System.out.println("Please create a course first!");
                    } else {
                        displayer.displayCourseDetails(course);
                    }
                    break;
                case 0:
                    inputter.close();
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Displayer displayer = new Displayer();
        Scanner scan = new Scanner(System.in);
        Student student = null;
        Course course = null;

        while (true) {
            System.out.println("================= Student Management System =================");
            System.out.println("Menu:");
            System.out.println("1. Create Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Assign Grade to Student");
            System.out.println("5. Drop Course");
            System.out.println("6. Drop All Courses in Block");
            System.out.println("7. View Student Details");
            System.out.println("8. View Course Details");
            System.out.println("9. Update Student Type");
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
                    if (student instanceof RegularStudent) {
                        if (student.getCourses().size() < 2) { // Regular students can enroll only in their predefined courses
                            student.enroll(course);
                            System.out.println("Student enrolled in course: " + course.getDetails());
                        } else {
                            System.out.println("Regular students can only enroll in their predefined courses.");
                        }
                    } else {
                        student.enroll(course);
                        System.out.println("Student enrolled in course: " + course.getDetails());
                    }
                    break;
                case 4:
                    if (student != null && course != null) {
                        double grade = inputter.getGradeInput();
                        course.assignGrade(student, grade);
                        System.out.println("Grade assigned successfully!");
                    } else {
                        System.out.println("Please create a student and a course first.");
                    }
                    break;
                case 5:
                    if (student != null && course != null) {
                        student.dropCourse(course);
                        System.out.println("Course dropped successfully!");
                    } else {
                        System.out.println("Please create a student and a course first.");
                    }
                    break;
                case 6:
                    if (student instanceof RegularStudent) {
                        ((RegularStudent) student).dropBlock();
                        System.out.println("All courses in block dropped successfully!");
                    } else {
                        System.out.println("Only regular students can drop all courses in their block.");
                    }
                    break;
                case 7:
                    if (student != null) {
                        displayer.displayStudentDetails(student);
                    } else {
                        System.out.println("Please create a student first.");
                    }
                    break;
                case 8:
                    if (course != null) {
                        displayer.displayCourseDetails(course);
                    } else {
                        System.out.println("Please create a course first.");
                    }
                    break;
                case 9:
                    if (student != null) {
                        System.out.print("Enter new type (Regular/Irregular): ");
                        String newType = scan.nextLine();
                        student.updateType(newType);
                        System.out.println("Student type updated to: " + newType);
                    } else {
                        System.out.println("Please create a student first.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    inputter.close();
                    scan.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
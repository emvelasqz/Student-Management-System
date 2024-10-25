import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n================= Student Management System =================");
            System.out.println("=== Student Operations ===");
            System.out.println("1. Create Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            
            System.out.println("\n=== Course Operations ===");
            System.out.println("6. Create Course");
            System.out.println("7. View All Courses");
            System.out.println("8. Update Course");
            System.out.println("9. Delete Course");
            System.out.println("10. Filter Course Details");
            
            System.out.println("\n=== Enrollment and Grades ===");
            System.out.println("11. Enroll Student in Course");
            System.out.println("12. Assign Grade to Student");
            
            System.out.println("\n0. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scan.nextLine().trim());
                switch (choice) {
                    case 1 -> controller.createStudent();
                    case 2 -> controller.viewAllStudents();
                    case 3 -> controller.updateStudent();
                    case 4 -> controller.deleteStudent();
                    case 5 -> controller.searchStudentByID();
                    case 6 -> controller.createCourse();
                    case 7 -> controller.viewAllCourses();
                    case 8 -> controller.updateCourse();
                    case 9 -> controller.deleteCourse();
                    case 10 -> controller.filterCourseDetails();
                    case 11 -> controller.enrollStudentInCourse();
                    case 12 -> controller.assignGrade();
                    case 0 -> {
                        System.out.println("Exiting the system. Goodbye!");
                        controller.close();
                        scan.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}
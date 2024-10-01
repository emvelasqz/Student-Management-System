import java.util.Scanner;

public class Inputter {
    private Scanner scan = new Scanner(System.in);

    // methods in main class
    public Student createStudent() {
        System.out.print("Enter Student ID: ");
        String studentID = scan.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Student Type (Regular/Irregular): ");
        String type = scan.nextLine();

        // if-else condition to determine student type
        if (type.equalsIgnoreCase("Regular")) {
            System.out.print("Enter Block (A to D):"); // to enroll in a block
            String block = scan.nextLine();
            return new RegularStudent(studentID, name, block); // assign the student in the chosen block
        } else {
            return new IrregularStudent(studentID, name);
        }
    }

    public Course createCourse() {
        System.out.println("Enter Course Name:");
        String courseName = scan.nextLine();
        System.out.println("Enter Course Code:");
        String courseCode = scan.nextLine();
        return new Course(courseName, courseCode);
    }

    public Schedule createSchedule() {
        System.out.println("Enter Day:");
        String day = scan.nextLine();
        System.out.println("Enter Time:");
        String time = scan.nextLine();
        System.out.println("Enter Block:");
        String block = scan.nextLine();
        return new Schedule(day, time, block);
    }

    public double getGradeInput() {
        System.out.print("Enter Grade (0-100): ");
        return scan.nextDouble();
    }

    public void close() {
        scan.close();
    }
}
import java.util.Scanner;

public class Inputter {
    private Scanner scan = new Scanner(System.in);

    // method to validate the student ID (numbers only)
    private String getValidStudentID() {
        String studentID;
        while (true) {
            System.out.print("Enter Student ID (numbers only): ");
            studentID = scan.nextLine();
            if (studentID.matches("\\d+")) { // a condition to make sure that the user only inputs digits 0-9 in the studentID
                break;
            } else {
                System.out.println("Invalid input! Please enter numeric characters only.");
            }
        }
        return studentID;
    }

    public Student createStudent() {
        // call the method to get the Student ID
        String studentID = getValidStudentID();

        String name = "";
        while (true) {
            System.out.print("Enter Student Name: ");
            name = scan.nextLine();
            // Validate if the name contains only letters and spaces
            if (name.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter alphabetic characters only.");
            }
        }

        String type = "";
        while (true) {
            System.out.print("Enter Student Type (Regular/Irregular): ");
            type = scan.nextLine();
            if (type.equalsIgnoreCase("Regular") || type.equalsIgnoreCase("Irregular")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Regular' or 'Irregular'.");
            }
        }

        String block = "";
        if (type.equalsIgnoreCase("Regular")) {
            while (true) {
                System.out.print("Enter Block (A to D): ");
                block = scan.nextLine().toUpperCase();
                if (block.matches("[A-D]")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a block (A, B, C, or D).");
                }
            }
            return new RegularStudent(studentID, name, block);
        } else {
            return new IrregularStudent(studentID, name);
        }
    }

    public Course createCourse() {
        System.out.println("Enter Course Name: ");
        String courseName = scan.nextLine();

        System.out.println("Enter Course Code: ");
        String courseCode = scan.nextLine();

        Course course = new Course(courseName, courseCode, createSchedule());

        System.out.print("Do you want to add a schedule to this course? (y/n): ");
        String addSchedule = scan.nextLine();
        
        while (addSchedule.equalsIgnoreCase("y")) {
            Schedule schedule = createSchedule();
            course.addSchedule(schedule);
            System.out.print("Do you want to add another schedule? (y/n): ");
            addSchedule = scan.nextLine();
        }

        return course;
    }

    public Schedule createSchedule() {
        String day = "";
        while (true) {
            System.out.println("Enter Day (e.g., Monday, Tuesday): ");
            day = scan.nextLine();
            if (!day.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid day.");
            }
        }

        String time = "";
        while (true) {
            System.out.println("Enter Time (e.g., 10:00 AM): ");
            time = scan.nextLine();
            if (!time.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid time.");
            }
        }

        String block = "";
        System.out.println("Enter Block: ");
        block = scan.nextLine();
        return new Schedule(day, time, block);
    }

    public double getGradeInput() {
        double grade = -1;
        while (true) {
            System.out.print("Enter Grade (0-100): ");
            if (scan.hasNextDouble()) {
                grade = scan.nextDouble();
                if (grade >= 0 && grade <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a grade between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scan.next();
            }
        }
        return grade;
    }

    public void close() {
        scan.close();
    }
}
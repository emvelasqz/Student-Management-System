import java.util.Scanner;

public class Inputter {
    private final Scanner scan = new Scanner(System.in);

    public Student createStudent() {
        String studentID;
        while (true) {
            System.out.print("Enter Student ID (numeric only): ");
            studentID = scan.nextLine().trim();
            if (isNumeric(studentID)) {
                break;
            }
            System.out.println("Invalid ID! Please enter a numeric Student ID.");
        }

        String name;
        while (true) {
            System.out.print("Enter Student Name (letters and spaces only): ");
            name = scan.nextLine().trim();
            if (isValidName(name)) {
                break;
            }
            System.out.println("Invalid name! Please enter a valid name without numbers.");
        }

        String type;
        while (true) {
            System.out.print("Enter Student Type (Regular/Irregular): ");
            type = scan.nextLine().trim();
            if (type.equalsIgnoreCase("Regular") || type.equalsIgnoreCase("Irregular")) {
                break;
            }
            System.out.println("Invalid type! Please enter 'Regular' or 'Irregular'.");
        }

        if (type.equalsIgnoreCase("Regular")) {
            String block;
            while (true) {
                System.out.println("\nAvailable Blocks:");
                System.out.println("Block A Schedule:");
                System.out.println("- Monday    8:00-9:30");
                System.out.println("- Wednesday 8:00-9:30");
                System.out.println("- Friday    8:00-9:30");
                
                System.out.println("\nBlock B Schedule:");
                System.out.println("- Tuesday   13:00-14:30");
                System.out.println("- Thursday  13:00-14:30");
                System.out.println("- Saturday  10:00-11:30");
                
                System.out.print("\nEnter Block (A/B): ");
                block = scan.nextLine().trim().toUpperCase();
                if (block.equals("A") || block.equals("B")) {
                    break;  
                }
                System.out.println("Invalid block! Please enter 'A' or 'B'.");
            }
            return new RegularStudent(studentID, name, block);
        } else {
            return new IrregularStudent(studentID, name);
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+"); // checks if the string contains only digits
    }
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+"); // checks if the name contains only letters and spaces
    }

    public Course createCourse() {
        System.out.print("Enter Course Name: ");
        String courseName = scan.nextLine().trim();

        String courseCode;
        while (true) {
            System.out.print("Enter Course Code: ");
            courseCode = scan.nextLine().trim();
            if (!courseCode.isEmpty()) {
                break;
            }
            System.out.println("Course code cannot be empty!");
        }

        Course course = new Course(courseName, courseCode);

        System.out.print("Add a schedule? (y/n): ");
        while (scan.nextLine().equalsIgnoreCase("y")) {
            Schedule schedule = createSchedule();
            course.addSchedule(schedule);
            System.out.print("Add another schedule? (y/n): ");
        }
        return course;
    }

    public Schedule createSchedule() {
        System.out.print("Enter Day: ");
        String day = scan.nextLine().trim();

        System.out.print("Enter Time: ");
        String time = scan.nextLine().trim();

        System.out.print("Enter Block: ");
        String block = scan.nextLine().trim();

        return new Schedule(day, time, block);
    }

    public double getGradeInput() {
        double grade;
        while (true) {
            try {
                System.out.print("Enter Grade (1.00 - 5.00): ");
                grade = Double.parseDouble(scan.nextLine().trim());
                if (isValidCollegeGrade(grade)) {
                    break;
                } else {
                    System.out.println("Invalid grade! Please enter a valid college grade.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        return grade;
    }

    private boolean isValidCollegeGrade(double grade) {
        double[] validGrades = {1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0, 5.0};
        for (double validGrade : validGrades) {
            if (Double.compare(grade, validGrade) == 0) {
                return true;
            }
        }
        return false;
    }

    public void close() {
        scan.close();
    }
}
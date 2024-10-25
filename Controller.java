import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Inputter inputter;
    private final Displayer displayer;
    private final Scanner scan;
    private final List<Student> students;
    private final List<Course> courses;

    public Controller() {
        this.inputter = new Inputter();
        this.displayer = new Displayer();
        this.scan = new Scanner(System.in);
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void createStudent() {
        Student student = inputter.createStudent();
        students.add(student);
        System.out.println("Student created successfully: " + student.getDetails());
        System.out.println("Total Fees: " + student.calculateTotalFees() + " PHP");
    }

    public void createCourse() {
        Course course = inputter.createCourse();
        courses.add(course);
        System.out.println("Course created successfully: " + course.getDetails());
    }

    public void enrollStudentInCourse() {
        Student student = selectStudent();
        Course course = selectCourse();
        student.enroll(course);
        System.out.println("Student enrolled successfully!");
    }

    public void assignGrade() {
        Student student = selectStudent();
        Course course = selectCourse();
        double grade = inputter.getGradeInput();
        course.assignGrade(student, grade);
        System.out.println("Grade assigned successfully!");
    }

    public void searchStudentByID() {
        System.out.print("Enter Student ID: ");
        String studentID = scan.nextLine().trim();
        boolean found = false;
    
        for (Student student : students) {
            if (student.getStudentID().equalsIgnoreCase(studentID)) {
                displayer.displayStudentDetails(student);
                System.out.println("Total Fees: " + student.calculateTotalFees() + " PHP");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }
    
    public void filterCourseDetails() {
        System.out.print("Enter keyword to filter courses: ");
        String keyword = scan.nextLine().trim();
        boolean found = false;
    
        for (Course course : courses) {
            if (course.getName().toLowerCase().contains(keyword.toLowerCase()) || 
                course.getSchedule().toLowerCase().contains(keyword.toLowerCase())) {
                displayer.displayCourseDetails(course);
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No courses found matching the keyword: " + keyword);
        }
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        System.out.println("\n=== All Students ===");
        for (Student student : students) {
            displayer.displayStudentDetails(student);
            System.out.println("-------------------");
        }
    }

    public void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found in the system.");
            return;
        }
        System.out.println("\n=== All Courses ===");
        for (Course course : courses) {
            displayer.displayCourseDetails(course);
            System.out.println("-------------------");
        }
    }

    public void updateStudent() {
        Student student = selectStudent();
        if (student == null) return;

        System.out.println("Current student details:");
        displayer.displayStudentDetails(student);

        System.out.print("Enter new name (or press Enter to keep current): ");
        String newName = scan.nextLine().trim();
        if (!newName.isEmpty()) {
            student.setName(newName);
        }

        if (student instanceof RegularStudent) {
            System.out.print("Enter new block (A/B) (or press Enter to keep current): ");
            String newBlock = scan.nextLine().trim().toUpperCase();
            if (!newBlock.isEmpty() && (newBlock.equals("A") || newBlock.equals("B"))) {
                ((RegularStudent) student).setBlock(newBlock);
            }
        }

        System.out.println("Student updated successfully!");
    }

    public void updateCourse() {
        Course course = selectCourse();
        if (course == null) return;

        System.out.println("Current course details:");
        displayer.displayCourseDetails(course);

        System.out.print("Enter new course name (or press Enter to keep current): ");
        String newName = scan.nextLine().trim();
        if (!newName.isEmpty()) {
            course.setName(newName);
        }

        System.out.print("Update schedules? (y/n): ");
        if (scan.nextLine().trim().equalsIgnoreCase("y")) {
            course.clearSchedules();
            System.out.print("Add a schedule? (y/n): ");
            while (scan.nextLine().equalsIgnoreCase("y")) {
                Schedule schedule = inputter.createSchedule();
                course.addSchedule(schedule);
                System.out.print("Add another schedule? (y/n): ");
            }
        }

        System.out.println("Course updated successfully!");
    }

    public void deleteStudent() {
        Student student = selectStudent();
        if (student == null) return;

        System.out.println("Are you sure you want to delete this student?");
        displayer.displayStudentDetails(student);
        System.out.print("Confirm deletion (y/n): ");
        if (scan.nextLine().trim().equalsIgnoreCase("y")) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        }
    }

    public void deleteCourse() {
        Course course = selectCourse();
        if (course == null) return;

        System.out.println("Are you sure you want to delete this course?");
        displayer.displayCourseDetails(course);
        System.out.print("Confirm deletion (y/n): ");
        if (scan.nextLine().trim().equalsIgnoreCase("y")) {
            for (Student student : students) {
                student.getCourses().remove(course);
            }
            courses.remove(course);
            System.out.println("Course deleted successfully!");
        }
    }

    private Student selectStudent() {
        while (true) {
            try {
                displayStudents();
                System.out.print("Select a student: ");
                int index = Integer.parseInt(scan.nextLine().trim()) - 1;
                return students.get(index);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Invalid selection! Please try again.");
            }
        }
    }

    private Course selectCourse() {
        while (true) {
            try {
                displayCourses();
                System.out.print("Select a course: ");
                int index = Integer.parseInt(scan.nextLine().trim()) - 1;
                return courses.get(index);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Invalid selection! Please try again.");
            }
        }
    }

    private void displayStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getDetails());
        }
    }

    private void displayCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getDetails());
        }
    }

    public void close() {
        inputter.close();
        scan.close();
    }
}
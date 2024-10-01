import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Displayer displayer = new Displayer();
        Scanner scan = new Scanner(System.in);
        List<Student> students = new ArrayList<>(); // list to manage multiple students
        List<Course> courses = new ArrayList<>(); // list to manage multiple courses

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
            System.out.print("\nEnter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    Student student = inputter.createStudent();
                    if (student instanceof RegularStudent) {
                        List<Course> predefinedCourses = ((RegularStudent) student).getCourses();
                        for (Course course : predefinedCourses) {
                            if (!courses.contains(course)) {
                                courses.add(course);
                            }
                        }
                    }
                    students.add(student);
                    System.out.println("Student created successfully!");
                    break;
                case 2:
                    Course course = inputter.createCourse();
                    courses.add(course);
                    System.out.println("Course created successfully!");
                    break;
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students available. Please create a student first.");
                    } else if (courses.isEmpty()) {
                        System.out.println("Please create a course first.");
                    } else {
                        Student selectedStudent = selectStudent(students, scan);
                        Course selectedCourse = selectCourse(courses, scan);

                        if (selectedStudent instanceof RegularStudent) {
                            RegularStudent regularStudent = (RegularStudent) selectedStudent;
                            if (regularStudent.getCourses().contains(selectedCourse)) {
                                System.out.println("Regular student is already enrolled in this course.");
                            } else {
                                System.out.println("Regular students cannot enroll in additional courses.");
                            }
                        } else {
                            selectedStudent.enroll(selectedCourse);
                            System.out.println("Irregular student enrolled in course: " + selectedCourse.getDetails());
                        }
                    }
                    break;
                case 4:
                    if (students.isEmpty() || courses.isEmpty()) {
                        System.out.println("Please create a student and a course first.");
                    } else {
                        Student selectedStudent = selectStudent(students, scan);
                        Course selectedCourse = selectCourse(courses, scan);
                        double grade = inputter.getGradeInput();
                        selectedCourse.assignGrade(selectedStudent, grade);
                        System.out.println("Grade assigned successfully!");
                    }
                    break;
                case 5:
                    if (students.isEmpty() || courses.isEmpty()) {
                        System.out.println("Please create a student and a course first.");
                    } else {
                        Student selectedStudent = selectStudent(students, scan);
                        Course selectedCourse = selectCourse(courses, scan);
                        selectedStudent.dropCourse(selectedCourse);
                        System.out.println("Course dropped successfully!");
                    }
                    break;
                case 6:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        Student selectedStudent = selectStudent(students, scan);
                        if (selectedStudent instanceof RegularStudent) {
                            ((RegularStudent) selectedStudent).dropBlock();
                            System.out.println("All courses in block dropped successfully!");
                        } else {
                            System.out.println("Only regular students can drop all courses in their block.");
                        }
                    }
                    break;
                case 7:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        Student selectedStudent = selectStudent(students, scan);
                        displayer.displayStudentDetails(selectedStudent);
                    }
                    break;
                case 8:
                    if (!courses.isEmpty()) {
                        Course selectedCourse = selectCourse(courses, scan);
                        displayer.displayCourseDetails(selectedCourse);
                    } else {
                        System.out.println("Please create a course first.");
                    }
                    break;
                case 9:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        Student selectedStudent = selectStudent(students, scan);
                        System.out.print("Enter new type (Regular/Irregular): ");
                        String newType = scan.nextLine();
                        selectedStudent.updateType(newType);
                        System.out.println("Student type updated to: " + newType);
                    }
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    inputter.close();
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // method to select a student from the list
    private static Student selectStudent(List<Student> students, Scanner scan) {
        System.out.print("Select a student: ");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getDetails());
        }
        int selectedIndex = scan.nextInt() - 1;
        scan.nextLine(); 
        return students.get(selectedIndex);
    }

    // method to select a course from the list
    private static Course selectCourse(List<Course> courses, Scanner scan) {
        System.out.print("Select a course: ");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getDetails());
        }
        int selectedIndex = scan.nextInt() - 1;
        scan.nextLine(); 
        return courses.get(selectedIndex);
    }
}
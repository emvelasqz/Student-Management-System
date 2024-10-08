import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Displayer displayer = new Displayer();
        Scanner scan = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

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
            System.out.println("10. Search Student by ID");
            System.out.println("11. Filter Courses by Block");
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
                        try {
                            Student selectedStudent = selectStudent(students, scan);
                            Course selectedCourse = selectCourse(courses, scan);
                            double grade = inputter.getGradeInput();
                            if (grade < 0 || grade > 100) {
                                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                            } else {
                                selectedCourse.assignGrade(selectedStudent, grade);
                                System.out.println("Grade assigned successfully!");
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid selection. Please try again.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
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
                        System.out.println("Updated Admission Fee: " + selectedStudent.getAdmissionFee());
                    }
                    break;
                case 10:
                    System.out.print("Enter student ID to search: ");
                    String studentID = scan.nextLine();
                    Student foundStudent = searchByID(students, studentID);
                    if (foundStudent != null) {
                        displayer.displayStudentDetails(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 11:
                    System.out.print("Enter block to filter courses: ");
                    String block = scan.nextLine();
                    List<Course> filteredCourses = filterByBlock(courses, block);
                    if (!filteredCourses.isEmpty()) {
                        for (Course filteredCourse : filteredCourses) {
                            displayer.displayCourseDetails(filteredCourse);
                        }
                    } else {
                        System.out.println("No courses found for block " + block);
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

    private static Student searchByID(List<Student> students, String studentID) {
        for (Student student : students) {
            if (student.studentID.equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private static List<Course> filterByBlock(List<Course> courses, String block) {
        List<Course> filteredCourses = new ArrayList<>();
        for (Course course : courses) {
            for (Schedule schedule : course.schedules) {
                if (schedule.getBlock().equalsIgnoreCase(block)) {
                    filteredCourses.add(course);
                    break;
                }
            }
        }
        return filteredCourses;
    }

    private static Student selectStudent(List<Student> students, Scanner scan) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getDetails());
        }
        System.out.print("Select a student: ");
        int selectedIndex = scan.nextInt() - 1;
        scan.nextLine();
        
        if (selectedIndex < 0 || selectedIndex >= students.size()) {
            System.out.println("Invalid selection. Please try again.");
            return selectStudent(students, scan); // Recursive call to try again
        }

        return students.get(selectedIndex);
    }

    private static Course selectCourse(List<Course> courses, Scanner scan) {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getDetails());
        }
        System.out.print("Select a course: ");
        int selectedIndex = scan.nextInt() - 1;
        scan.nextLine();
        
        if (selectedIndex < 0 || selectedIndex >= courses.size()) {
            System.out.println("Invalid selection. Please try again.");
            return selectCourse(courses, scan);
        }

        return courses.get(selectedIndex);
    }
}
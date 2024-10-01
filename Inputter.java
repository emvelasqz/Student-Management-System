import java.util.Scanner;

public class Inputter {
    public Scanner scan = new Scanner(System.in);

    public Student createStudent() {
        System.out.println("Enter Student ID: ");
        String studentID = scan.nextLine();
        System.out.println("Enter Student Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Student Type (Regular/Irregular): ");
        String type = scan.nextLine();

        // if-else condition to determine student type
        if (type.equalsIgnoreCase("Regular")) {
            System.out.println("Enter Block (A to D):"); // to enroll in a block
            String block = scan.nextLine();
            return new RegularStudent(studentID, name, block); // assign the student in the chosen block
        } else {
            return new IrregularStudent(studentID, name);
        }
    }
}
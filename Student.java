import java.util.ArrayList;
import java.util.List;

public abstract class Student {
    // attributes
    protected String studentID;
    protected String name;
    protected String type; // regular or irregular
    protected double admissionFee;

    public Student(String studentID, String name, String type) {
        this.studentID = studentID;
        this.name = name;
        this.type = type;
        this.admissionFee = setAdmissionFee(type);
    }

    // methods


    public String getDetails() {
        return "Name: " + name + ", ID: " + studentID + ", Type: " + type + ", Admission Fee: " + admissionFee;
    }

    private double setAdmissionFee(String type) {
        if (type.equalsIgnoreCase("Regular")) {
            return 10000.0;
        } else {
            return 10000.0 + 2000.0; 
        }
    }

    public void updateType(String newType) {
        this.type = newType;
        this.admissionFee = setAdmissionFee(newType); // update the fee based on new type
    }

    public double getAdmissionFee() {
        return admissionFee;
    }

    public abstract double calculateTotalFees();
}
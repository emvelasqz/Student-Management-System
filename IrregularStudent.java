public class IrregularStudent extends Student {
    private static final double FEE = 12000.0;

    public IrregularStudent(String studentID, String name) {
        super(studentID, name, "Irregular");
    }

    @Override
    public double calculateTotalFees() {
        return FEE;
    }
}
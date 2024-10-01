class IrregularStudent extends Student {
    private static final double additionalAdmissionFee = 2000.0; // a constant value for the additional fee

    // constructor
    public IrregularStudent(String studentID, String name) {
        super(studentID, name, "Irregular");
    }

    @Override // to override the fixed calculation
    public double calculateTotalFees() {
        return getAdmissionFee() + additionalAdmissionFee; // standard fee + additional fee
    }
}
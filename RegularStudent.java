public class RegularStudent extends Student {
    private String block;

    public RegularStudent(String studentID, String name, String block) {
        super(studentID, name);
        this.type = "Regular";
        this.block = block;
    }

    // method to retrieve block
    public getBlock() {
        return block;
    }

    public void enroll(Course course) {
        System.out.println("Regular students cannot enroll in additional courses."); // message will print out - regular students have predefined schedule
    }
}
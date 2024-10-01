public class RegularStudent extends Student {
    private String block;

    public RegularStudent(String studentID, String name, String block) {
        super(studentID, name);
        this.type = "Regular";
        this.block = block;
        assignPredefinedCourses();
    }

    // method to retrieve block
    public String getBlock() {
        return block;
    }

    // a private method of predefined schedules for reg students
    private void assignPredefinedCourses() {
        if (block.equals("A")) {
            enroll(new Course("Introduction to Web Programming", "2067", new Schedule("Thursday", "8:30 AM")));
            enroll(new Course("Introduction to Cyber Security", "2069", new Schedule("Friday", "11:00 AM")));
        } else if (block.equals("B")) {
            enroll(new Course("Data Structures & Algorithms", "2065", new Schedule("Monday", "12:00 PM")));
            enroll(new Course("Object-Oriented Programming", "2066", new Schedule("Tuesday", "4:00 PM")));
        } else if (block.equals("C")) {
            enroll(new Course("Operating Systems Fundamentals", "2068", new Schedule("Wednesday", "9:00 AM")));
            enroll(new Course("Calculus", "2070", new Schedule("Thursday", "11:00 AM")));
        } else if (block.equals("D")) {
            enroll(new Course("Physical Education 3", "9211", new Schedule("Friday", "2:00 PM")));
            enroll(new Course("Ethics", "2071", new Schedule("Monday", "3:00 PM")));
        }
    }

    public void dropBlock() {
        this.courses.clear(); // drop all courses
    }

    @Override
    public void enroll(Course course) {
        if (courses.size() >= 2) {
            System.out.println("Regular students are already enrolled in predefined courses for their block and cannot enroll in additional courses."); // message will print out - regular students have predefined schedule
        } else {
            super.enroll(course);
        }
    }

    @Override
    public double calculateTotalFees() {
        return 10000.0; // standard fee
    }
}
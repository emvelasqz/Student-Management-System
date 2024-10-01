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
            Course course1 = new Course("Introduction to Web Programming", "2067", null);
            course1.addSchedule(new Schedule("Thursday", "8:30 AM", "A"));
            enroll(course1);
    
            Course course2 = new Course("Introduction to Cyber Security", "2069", null);
            course2.addSchedule(new Schedule("Friday", "11:00 AM", "A"));
            enroll(course2);
        } else if (block.equals("B")) {
            Course course1 = new Course("Data Structures & Algorithms", "2065", null);
            course1.addSchedule(new Schedule("Monday", "12:00 PM", "B"));
            enroll(course1);
    
            Course course2 = new Course("Object-Oriented Programming", "2066", null);
            course2.addSchedule(new Schedule("Tuesday", "4:00 PM", "B"));
            enroll(course2);
        } else if (block.equals("C")) {
            Course course1 = new Course("Operating Systems Fundamentals", "2068", null);
            course1.addSchedule(new Schedule("Wednesday", "9:00 AM", "C"));
            enroll(course1);
    
            Course course2 = new Course("Calculus", "2070", null);
            course2.addSchedule(new Schedule("Thursday", "11:00 AM", "C"));
            enroll(course2);
        } else if (block.equals("D")) {
            Course course1 = new Course("Physical Education 3", "9211", null);
            course1.addSchedule(new Schedule("Friday", "2:00 PM", "D"));
            enroll(course1);
    
            Course course2 = new Course("Ethics", "2071", null);
            course2.addSchedule(new Schedule("Monday", "3:00 PM", "D"));
            enroll(course2);
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
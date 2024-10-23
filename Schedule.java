import java.util.List;

public class Schedule {
    private String day;
    private String time;
    private String block;
    protected List<Schedule> schedules;

    public Schedule(String day, String time) {
        this.day = day;
        this.time = time;
    }

    public Schedule(String day, String time, String block) {
        this.day = day;
        this.time = time;
        this.block = block;
    }

    public String getScheduleDetails() {
        return "Day: " + day + "\nTime: " + time + "\nBlock: " + block;
    }

    
    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
    
    public void viewSchedules() {
        if (schedules.isEmpty()) {
            System.out.println("No schedules available for this course.");
            return;
        }
        
        for (Schedule schedule : schedules) {
            System.out.println(schedule.getScheduleDetails());
        }
    }

    public void updateTime(String newTime) {
        this.time = newTime;
    }

    public void updateDay(String newDay) {
        this.day = newDay;
    }

    public void updateBlock(String newBlock) {
        this.block = newBlock;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getBlock() {
        return block;
    }
}
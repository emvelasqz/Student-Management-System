public class Schedule {
    private String day;
    private String time;
    private String block;

    public Schedule(String day, String time, String block) {
        this.day = day;
        this.time = time;
        this.block = block;
    }

    public String getScheduleDetails() {
        return "Day: " + day + "\nTime: " + time + "\nBlock: " + block;
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
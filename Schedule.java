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
        return "Day: " + day + ", Time: " + time + ", Block: " + block;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Schedule schedule = (Schedule) obj;
        return day.equals(schedule.day) && time.equals(schedule.time) && block.equals(schedule.block);
    }

    @Override
    public int hashCode() {
        return day.hashCode() + time.hashCode() + block.hashCode();
    }
}
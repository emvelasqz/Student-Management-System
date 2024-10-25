import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegularStudent extends Student {
    private static final double FEE = 10000.0;
    private String block;
    private static final Map<String, List<Schedule>> BLOCK_SCHEDULES = new HashMap<>();
    
    static {
        List<Schedule> blockASchedules = new ArrayList<>();
        blockASchedules.add(new Schedule("Monday", "8:00-9:30", "A"));
        blockASchedules.add(new Schedule("Wednesday", "8:00-9:30", "A"));
        blockASchedules.add(new Schedule("Friday", "8:00-9:30", "A"));
        
        List<Schedule> blockBSchedules = new ArrayList<>();
        blockBSchedules.add(new Schedule("Tuesday", "13:00-14:30", "B"));
        blockBSchedules.add(new Schedule("Thursday", "13:00-14:30", "B"));
        blockBSchedules.add(new Schedule("Saturday", "10:00-11:30", "B"));
        
        BLOCK_SCHEDULES.put("A", blockASchedules);
        BLOCK_SCHEDULES.put("B", blockBSchedules);
    }
    
    public RegularStudent(String studentID, String name, String block) {
        super(studentID, name, "Regular");
        this.block = block;
    }
    
    public String getBlock() {
        return block;
    }
    
    public void setBlock(String block) {
        this.block = block;
    }
    
    public static List<Schedule> getBlockSchedules(String block) {
        return BLOCK_SCHEDULES.getOrDefault(block, new ArrayList<>());
    }
    
    @Override
    public double calculateTotalFees() {
        return FEE;
    }
}
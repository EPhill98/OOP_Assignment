

public class LeaveOverLappedEX  extends Exception{
    private LeaveDay day; 
    public LeaveOverLappedEX(){
        super("Leave overlapped: The leave period DATE to DATE is found!");
    }
    public LeaveOverLappedEX(String m){
        super(m);
    }
    public LeaveOverLappedEX(LeaveDay d) {
        this.day = d;
        }
        
    @Override
    public String toString() {
        return String.format("Leave overlapped: The leave period %s to %s is found!",day.getStartDay(),day.getEndDay());
    }

        
}

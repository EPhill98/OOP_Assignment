public class LeaveDay extends Day {
    private Day startDay;
    private Day endDay;

    public LeaveDay(String sDay) {
        super(sDay);
    }

    public Day getStartDay() {
        return startDay;
    }

    public void setStartDay(Day startDay) {
        this.startDay = startDay;
    }

    public Day getEndDay() {
        return endDay;
    }

    public void setEndDay(Day endDay) {
        this.endDay = endDay;
    }
    public int getDateComp(){
        String a = String.valueOf(endDay.getYear());
        String b = String.valueOf(endDay.getMonth());
        if (b.length() == 1){
            b = "0" + b;
        }
        String c = String.valueOf(endDay.getDay());
        if (c.length() == 1){
            c = "0" + c;
        }

        return Integer.parseInt(a + b + c);
    }

}

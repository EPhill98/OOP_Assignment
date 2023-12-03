public class LeaveDay extends Day implements Comparable<LeaveDay>{
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

    public static int getDateComp(Day d){
        String a = String.valueOf(d.getYear());
        String b = String.valueOf(d.getMonth());
        if (b.length() == 1){
            b = "0" + b;
        }
        String c = String.valueOf(d.getDay());
        if (c.length() == 1){
            c = "0" + c;
        }

        return Integer.parseInt(a + b + c);
    }

    @Override
    public int compareTo(LeaveDay aDay) {
        int thisDay = this.getDateComp();
        int d2 = aDay.getDateComp();
        if (thisDay > d2){
            return 1;
        } else if (thisDay == d2){
            return 0;
        } else {
            return -1;
        }
    }

}


public class Project implements Comparable<Project> {
    private String proId;
    private Day startDay;
    private Day endDay;
    private int length;
    private String teamName;
    private Team team;

    public Project(String id, Day sDay, int length) {
        this.proId = id;
        this.startDay = sDay;
        this.length = length;
        this.teamName = "--";
        endDay = startDay;
        if (length > 1) {
            for (int i = 0; i < length-1; i++) {
                if ((Day.valid(endDay.getYear(), endDay.getMonth(), endDay.getDay()+1))) {
                    endDay = endDay.nextDay();
                } else if (Day.valid(endDay.getYear(), endDay.getMonth() + 1, 1)) {
                    endDay = new Day(endDay.getYear(), endDay.getMonth() + 1, 1);
                }
            }
        }
    }

    @Override
    public int compareTo(Project o) {
        return this.proId.compareTo(o.proId);
    }

    @Override
    public String toString() {
        String endString = printTeam();
        String result = String.format("%-9s%-13s%-13s%-13s\n", 
                this.proId, startDay, endDay, endString);
        return result;

    }

    private String printTeam() {
        if (team==null){
            return "--";
        } else {
            return String.format("%s (%s)",teamName,team.getHead().getName());
        }
    }

    public String getProId() {
        return proId;
    }

    public Day getStartDay() {
        return startDay;
    }

    public Day getEndDay() {
        return endDay;
    }

    public int getLength() {
        return length;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(Team t) {
        this.team = t;
        this.teamName = t.getTeamName();
    }

    public void setTeam(Object object) {
        if (object == null){
            this.teamName = "--";
        }
    }

    public void setTeamNull(){
        this.team = null;
        this.teamName = "--";
    }

}
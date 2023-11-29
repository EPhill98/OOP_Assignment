import java.util.ArrayList;

public class Team implements Comparable<Team> {
    private String teamName;
    private Employee head;
    private Day dateSetup;
    private ArrayList<Employee> teamMembers;

    public Team(String n, Employee hd) {
        this.teamName = n;
        this.head = hd;
        this.dateSetup = SystemDate.getInstance().clone();
        head.setAssigned(true);
        head.setTeam(n);
        teamMembers = new ArrayList<Employee>();
    }

    public static void list(ArrayList<Team> lst) {
        System.out.printf("%-30s%-10s%-13s\n", "Team Name", "Leader", "Setup Date");
        for (Team t : lst) {
            System.out.printf("%-30s%-10s%-13s\n",
                    t.teamName, t.head.getName(), t.dateSetup);
        }
    }

    @Override
    public int compareTo(Team another) {
        return this.teamName.compareTo(another.teamName);
    }

    public String getTeamName() {
        return teamName;
    }

    public Employee getHead() {
        return head;
    }

    public Day getDateSetup() {
        return dateSetup;
    }

    public void addEmployee(Employee e) {
        this.teamMembers.add(e);
    }

    public void removeEmployee(Employee e) {
        this.teamMembers.remove(e);
    }

    public void listMembers() {
        System.out.printf("%-30s%-10s%-13s\n",
                "Role", "Name", "Current / coming leaves");
        System.out.printf("%-30s%-10s%-13s\n",
                "Leader", this.head.getName(), this.head.printLeaveTM());
        for (Employee e : teamMembers) {
            System.out.printf("%-30s%-10s%-13s\n", "Member", e.getName(), e.printLeaveTM());
        }
    }

}

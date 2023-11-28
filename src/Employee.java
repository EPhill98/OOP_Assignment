import java.util.ArrayList;

public class Employee implements Comparable<Employee> {
    private String name;
    private int annualLeaves;
    private boolean isAssigned;
    private String assigendTeamName;
    private ArrayList<LeaveDay> takenLeaave;

    public Employee(String n, int yle) {
        this.name = n;
        this.annualLeaves = yle;
        this.isAssigned = false;
        takenLeaave = new ArrayList<>();
    }

    public static Employee searchEmployee(ArrayList<Employee> list, String name) {
        for (Employee e : list) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Employee another) {
        if (this.name.equals(another.name))
            return 0;
        else if (this.name.compareTo(another.name) > 0)
            return 1;
        else
            return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnnualLeaves() {
        return annualLeaves;
    }

    public void setAnnualLeaves(int annualLeaves) {
        this.annualLeaves = annualLeaves;
    }

    @Override
    public String toString() {
        return name + " (Entitled Annual Leaves: " + annualLeaves + " days)";
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    public void setTeam(String n) {
        this.assigendTeamName = n;
    }

    public String getTeamName() {
        return assigendTeamName;
    }

    public String getAssigendTeamName() {
        return assigendTeamName;
    }

    public void setAssigendTeamName(String assigendTeamName) {
        this.assigendTeamName = assigendTeamName;
    }

    public ArrayList<LeaveDay> getTakenLeaave() {
        return takenLeaave;
    }

    public void setTakenLeaave(ArrayList<LeaveDay> takenLeaave) {
        this.takenLeaave = takenLeaave;
    }

    public void addLeave(LeaveDay d) {
        this.takenLeaave.add(d);
    }

    public void deleteLeave() {
        takenLeaave.remove(-1);
    }

    public void printLeave() {
        String out = name + ": ";
        boolean flag = false;
        for (LeaveDay d : takenLeaave) {
            int d1 = d.getDateComp();
            int sDate = SystemDate.getInstance().getDateComp();
            if (d1 >= sDate)
                if (!flag) {
                    out += d.getStartDay() + " to " + d.getEndDay();
                    flag = true;
                } else {
                    out += ", " + d.getStartDay() + " to " + d.getEndDay();
                }
        }
        if (out.length() == (name.length() + 2)) {
            out += "--";
        }
        System.out.println(out);
    }

}

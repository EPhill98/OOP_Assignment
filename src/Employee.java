import java.util.ArrayList;

public class Employee implements  Comparable<Employee>{
    private String name;
    private int annualLeaves;
    private boolean isAssigned; 
    private String assigendTeamName;

    public Employee(String n, int yle){
        this.name = n;
        this. annualLeaves = yle;
        this.isAssigned = false;
    }

    public static Employee searchEmployee(ArrayList<Employee> list, String name){
       for (Employee e : list){
           if (e.getName().equals(name)){
               return e;
           }
       }
       return null;
    }
    

    @Override
    public int compareTo(Employee another) {
        if (this.name.equals(another.name)) return 0;
        else if (this.name.compareTo(another.name)>0) return 1;
        else return -1;
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
    public String getTeamName(){
        return assigendTeamName;
    }
}

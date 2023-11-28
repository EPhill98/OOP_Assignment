import java.util.ArrayList;
import java.util.Collections;

/**
 * Company class which holds information on employees, projects and teams.
 * Methods to change data.
 * 
 * @author Euan Phillips
 * @version 1.0
 */
public class Company {
    private ArrayList<Employee> allEmployees;
    private ArrayList<Team> allTeams;
    private ArrayList<Project> allProjects;


    private static Company instance = new Company();

    private Company() {
        allEmployees = new ArrayList<>();
        allTeams = new ArrayList<>();
        allProjects = new ArrayList<>();
    }

    public static Company getInstance() {
        return instance;
    }

    public void listTeams() {
        Team.list(allTeams);
    }

    public void listAllEmployees() {
        for (Employee e : allEmployees) {
            System.out.println(e.toString());
        }
    }

    public boolean checkEmployees(String name) {
        for (Employee employee : allEmployees) {
            if (employee.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Employee getEmployee(String eName){
        for (Employee e : allEmployees){
            if (e.getName().equals(eName)){
                return e;
            }
        } 
        return null;
    }

    public boolean checkTeam(String name) {
        for (Team t : allTeams) {
            if (t.getTeamName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Employee createEmployee(String n, int al) throws EmployeeAlreadyExists {
        Employee e;
        if (checkEmployees(n)) {
            throw new EmployeeAlreadyExists();
        } else {
            e = new Employee(n, al);
            allEmployees.add(e);
            Collections.sort(allEmployees);
        }
        return e;
    }

    public Team createTeam(String name, String head) throws EmployeeNotFound, TeamAlreadyExistsEx, IsAlreadyAssignedEx {
        Team t;
        Employee e = Employee.searchEmployee(allEmployees, head);
        if (!checkTeam(name)) {
            if (e != null) {
                if (!e.isAssigned()) {
                    t = new Team(name, e);
                    allTeams.add(t);
                    Collections.sort(allTeams);
                } else {
                    String errorMsg = String.format("%s has already joined another team: %s",
                            e.getName(), e.getTeamName());
                    throw new IsAlreadyAssignedEx(errorMsg);
                }
            } else {
                throw new EmployeeNotFound();
            }
            return t;
        } else {
            throw new TeamAlreadyExistsEx();
        }
    }

    public void addTeam(Team t) {
        allTeams.add(t);
        Collections.sort(allTeams);
    }

    public void removeTeam(Team t) {
        allTeams.remove(t);
    }

    public void addEmployee(Employee e) throws EmployeeAlreadyExists {
        allEmployees.add(e);
        Collections.sort(allEmployees);
    }

    public void removeEmplyee(Employee e) throws EmployeeNotFound {
        allEmployees.remove(e);
    }

    public Project createProject(String string, String string2, String len) throws ProjectAlreadyExists {
        Project p;
        if (!checkProject(string)) {
            Day d = new Day(string2);
            int length = Integer.parseInt(len);
            p = new Project(string, d, length);
            allProjects.add(p);
            Collections.sort(allProjects);
        } else {
            throw new ProjectAlreadyExists();
        }
        return p;
    }

    public void listProjects() {
        System.out.printf("%-9s%-13s%-13s%-13s\n",
                "Project", "Start Day", "End Day", "Team");
        for (Project p : allProjects) {
            System.out.println(p);
        }
    }

    public Project findProject(String string) {
        for (Project p : allProjects) {
            String pID = p.getProId();
            if (pID.equals(string)) {
                return p;
            }
        }
        return null;
    }

    public boolean checkProject(String name) {
        return (findProject(name) != null);
    }

    public Team findTeam(String string) {
        for (Team t : allTeams) {
            if (t.getTeamName().equals(string)) {
                return t;
            }
        }
        return null;
    }

    public void removeProject(Project p) {
        allProjects.remove(p);
    }

    public void addProject(Project p) {
        allProjects.add(p);
        Collections.sort(allProjects);
    }

    public void unassign(Project p) {
        p.setTeamNull();
    }

    public void listAllLeaves(){
        for (Employee e : allEmployees){
            if (!e.getTakenLeaave().isEmpty()){
                e.printLeave();
                System.out.println();
            }
        }
    }

}
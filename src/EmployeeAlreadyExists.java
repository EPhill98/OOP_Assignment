
public class EmployeeAlreadyExists extends Exception {
    public EmployeeAlreadyExists(){
        super("Employee already exists!");
    }
    public EmployeeAlreadyExists(String m){
        super(m);
    }
    @Override
    public String toString() {
        return "Employee already exists!";
    }

    

}

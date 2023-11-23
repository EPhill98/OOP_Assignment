
public class EmployeeAlreadyExists extends Exception {
    public EmployeeAlreadyExists(){
        super("Employee already exists!");
    }
    public EmployeeAlreadyExists(String m){
        super(m);
    }

}

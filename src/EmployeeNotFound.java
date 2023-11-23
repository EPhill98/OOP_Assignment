
public class EmployeeNotFound extends Exception{
    public EmployeeNotFound(){
        super("Employee not found!");
    }
    public EmployeeNotFound(String m){
        super(m);
    }

}


public class EmployeeNotFound extends Exception{
    String error = "Employee not found!";
    String m;
    public EmployeeNotFound(){
        super("Employee not found!");
    }
    public EmployeeNotFound(String m){
        super(m);
    }
    @Override
    public String toString() {
        return error;
    }
    

}

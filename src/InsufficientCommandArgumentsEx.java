
public class InsufficientCommandArgumentsEx extends Exception{

    public InsufficientCommandArgumentsEx(){
        super("Insufficient command arguments!");
    }
    public InsufficientCommandArgumentsEx(String m){
        super(m);
    }
    @Override
    public String toString() {
        return "Insufficient command arguments!";
    }

    

}

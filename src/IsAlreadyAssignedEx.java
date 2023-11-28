
public class IsAlreadyAssignedEx extends Exception{
    String m;
    public IsAlreadyAssignedEx(String m){
        this.m = m;
    }

    @Override
    public String toString() {
        return m;
    }
    
}

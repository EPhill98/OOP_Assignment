public class InsufficientBallanceEx extends Exception {
    private Employee e;
    public InsufficientBallanceEx(){
        super("Insufficient balance of annual leave. DAYS days left only!");
    }
    public InsufficientBallanceEx(String s){
        super(s);
    }
    public InsufficientBallanceEx(Employee e) {
        this.e = e;
    }
    @Override
    public String toString() {
        return String.format("Insufficient balance of annual leave. %s days left only!", e.getAnnualLeaves());
    }

    
    
}

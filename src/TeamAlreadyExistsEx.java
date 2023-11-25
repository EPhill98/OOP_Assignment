public class TeamAlreadyExistsEx extends Exception{
    public TeamAlreadyExistsEx(){
        super("Team already exists!");
    }
    public TeamAlreadyExistsEx(String m){
        super(m);
    }
    @Override
    public String toString() {
        return "Team already exists!";
    }

}

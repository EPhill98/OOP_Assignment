
public class TeamNotFoundEx extends Exception {
    public TeamNotFoundEx(){
        super("Team not found!");
    }
    public TeamNotFoundEx(String m){
        super(m);
    }
    @Override
    public String toString() {
        return "Team not found!";
    }
}

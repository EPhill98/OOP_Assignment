
public class ProjectAlreadyExists extends Exception{
    public ProjectAlreadyExists(){
        super("Project already exists!");
    }
    public ProjectAlreadyExists(String m){
        super(m);
    }

}

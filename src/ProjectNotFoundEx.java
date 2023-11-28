
public class ProjectNotFoundEx extends Exception{
    public ProjectNotFoundEx(){
        super("Project not found!");
    }
    public ProjectNotFoundEx(String m){
        super(m);
    }
    @Override
    public String toString() {
        return "Project not found!";
    }



}

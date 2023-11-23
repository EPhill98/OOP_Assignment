public class CmdListProject implements Command {

    @Override
    public void execute(String[] cmdParts) {
        Company c = Company.getInstance();
        c.listProjects();
    }
    
}

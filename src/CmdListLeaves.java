
public class CmdListLeaves implements Command {

    @Override
    public void execute(String[] cmdParts) {
        Company c = Company.getInstance();
        if (cmdParts.length == 1) {
            c.listAllLeaves();
        } else if (cmdParts.length == 2) {
            c.getEmployee(cmdParts[1]).printLeave();
        }
    }
}

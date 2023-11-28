
public class CmdAssign extends RecordedCommand {
    Team t;
    Project p;

    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx, ProjectNotFoundEx, TeamNotFoundEx {
        Company c = Company.getInstance();
        if (cmdParts.length != 3) {
            throw new InsufficientCommandArgumentsEx();
        } else {
            p = c.findProject(cmdParts[1]);
            t = c.findTeam(cmdParts[2]);
            if (p == null){
                throw new ProjectNotFoundEx();
            } else if (t == null){
                throw new TeamNotFoundEx();
            } else {
            p.setTeamName(t);
            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
            }
        }
    }

    @Override
    public void undoMe() {
        Company c = Company.getInstance();
        c.unassign(p);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        p.setTeamName(t);
        addUndoCommand(this);
    }
}

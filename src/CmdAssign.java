
public class CmdAssign extends RecordedCommand {
    Team t;
    Project p;

    public void execute(String[] cmdParts) {
        Company c = Company.getInstance();
        p = c.findProject(cmdParts[1]);
        t = c.findTeam(cmdParts[2]);
        p.setTeamName(t);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
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

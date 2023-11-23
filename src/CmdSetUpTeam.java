public class CmdSetUpTeam  extends  RecordedCommand{
    private Team t;

    @Override
    public void execute(String[] cmdParts) {
        Company c = Company.getInstance();
        t = c.createTeam(cmdParts[1],cmdParts[2]);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        Company c = Company.getInstance();
        c.removeTeam(t);
        addRedoCommand(this);


    }

    @Override
    public void redoMe() {
        Company c = Company.getInstance();
        c.addTeam(t);
        addUndoCommand(this);

    }
}

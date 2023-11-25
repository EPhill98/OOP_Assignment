public class CmdSetUpTeam  extends  RecordedCommand{
    private Team t;

    @Override
    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx {
        if (cmdParts.length == 3){
        Company c = Company.getInstance();
        try {
            t = c.createTeam(cmdParts[1],cmdParts[2]);
        } catch (EmployeeNotFound e) {
            System.out.println(e);
        } catch (TeamAlreadyExistsEx e) {
            System.out.println(e);
        }
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
        } else {
            throw new InsufficientCommandArgumentsEx();
        }
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

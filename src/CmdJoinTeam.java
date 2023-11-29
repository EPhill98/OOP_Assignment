public class CmdJoinTeam extends RecordedCommand{
    private Employee e;
    private Team t;

    @Override
    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx, EmployeeNotFound, TeamAlreadyExistsEx,
            ProjectNotFoundEx, TeamNotFoundEx {
        Company c = Company.getInstance();
        e = c.getEmployee(cmdParts[1]);
        t = c.findTeam(cmdParts[2]);
        t.addEmployee(e);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");

    }

    @Override
    public void undoMe() {
        t.removeEmployee(e);
        addRedoCommand(this);
        
    }

    @Override
    public void redoMe() {
        t.addEmployee(e);
        addUndoCommand(this);
    }
    
}

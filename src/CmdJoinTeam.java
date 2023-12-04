public class CmdJoinTeam extends RecordedCommand {
    private Employee e;
    private Team t;

    @Override
    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx, EmployeeNotFound, TeamAlreadyExistsEx,
            ProjectNotFoundEx, TeamNotFoundEx, HasJoinedTeamEX {
        Company c = Company.getInstance();
        if (cmdParts.length != 3) {
            throw new InsufficientCommandArgumentsEx();
        } else {
            e = c.getEmployee(cmdParts[1]);
            t = c.findTeam(cmdParts[2]);
            if (e == null || t == null) {
                if (t == null) {
                    throw new TeamNotFoundEx();
                } else {
                    throw new EmployeeNotFound();
                }
            } else {
                if (e.isAssigned()) {
                    throw new HasJoinedTeamEX(e, t);
                } else {
                    t.addEmployee(e);
                    e.setAssigendTeamName(t.getTeamName());
                    e.setAssigned(true);
                    addUndoCommand(this);
                    clearRedoList();
                    System.out.println("Done.");
                }
            }
        }

    }

    @Override
    public void undoMe() {
        t.removeEmployee(e);
        e.setAssigendTeamName(null);
        e.setAssigned(false);
        addRedoCommand(this);

    }

    @Override
    public void redoMe() {
        t.addEmployee(e);
        e.setAssigendTeamName(t.getTeamName());
        e.setAssigned(true);
        addUndoCommand(this);
    }

}

public class CmdSetUpTeam extends RecordedCommand {
    private Team t;

    @Override
    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx {
        if (cmdParts.length == 3) {
            Company c = Company.getInstance();
            try {
                t = c.createTeam(cmdParts[1], cmdParts[2]);
                addUndoCommand(this);
                clearRedoList();
                System.out.println("Done.");
            } catch (EmployeeNotFound e) {
                System.out.println(e);
            } catch (TeamAlreadyExistsEx e) {
                System.out.println(e);
            } catch (IsAlreadyAssignedEx e) {
                System.out.println(e);
            }
        } else {
            throw new InsufficientCommandArgumentsEx();
        }
    }

    @Override
    public void undoMe() {
        Company c = Company.getInstance();
        c.removeTeam(t);
        t.getHead().setTeam(null);
        t.getHead().setAssigned(false);
        addRedoCommand(this);

    }

    @Override
    public void redoMe() {
        Company c = Company.getInstance();
        c.addTeam(t);
        t.getHead().setTeam(t.getTeamName());
        t.getHead().setAssigned(true);
        addUndoCommand(this);

    }
}

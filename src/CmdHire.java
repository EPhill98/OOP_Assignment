public class CmdHire extends RecordedCommand {
    private Employee e;

    @Override
    public void execute(String[] cmdParts) {
        Company c = Company.getInstance();
        try {
            e = c.createEmployee(cmdParts[1], Integer.parseInt(cmdParts[2]));
            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        } catch (EmployeeAlreadyExists e) {
            System.out.println(e);
        }
    }

    @Override
    public void undoMe() {
        Company c = Company.getInstance();
        try {
            c.removeEmplyee(e);
            addRedoCommand(this);
        } catch (EmployeeNotFound e) {
            System.out.println(e);
        }
    }

    @Override
    public void redoMe() {
        Company c = Company.getInstance();
        try {
            c.addEmployee(e);
            addUndoCommand(this);
        } catch (EmployeeAlreadyExists e) {
            System.out.println(e);
        }
    }
}

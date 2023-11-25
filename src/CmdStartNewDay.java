public class CmdStartNewDay extends RecordedCommand {
    private String newDay;
    private String oldDay;

    @Override
    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx {
        if (cmdParts.length == 2) {
            oldDay = SystemDate.getInstance().toString();
            SystemDate.creatNewInstance(cmdParts[1]);
            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        } else {
            throw new InsufficientCommandArgumentsEx();
        }
    }

    @Override
    public void undoMe() {
        newDay = SystemDate.getInstance().toString();
        SystemDate.creatNewInstance(oldDay);
        addRedoCommand(this);

    }

    @Override
    public void redoMe() {
        oldDay = SystemDate.getInstance().toString();
        SystemDate.creatNewInstance(newDay);
        addUndoCommand(this);

    }
}

public class CmdCreateProject extends RecordedCommand {
    private Project p;

    @Override
    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx {
        Company c = Company.getInstance();
        if (cmdParts.length == 4) {
            try {
                Integer n = tryParse(cmdParts[3]);
                if (n != null){
                p = c.createProject(cmdParts[1], cmdParts[2], cmdParts[3]);
                addUndoCommand(this);
                clearRedoList();
                System.out.println("Done.");
                } 
            } catch (ProjectAlreadyExists e) {
                System.out.println("Project already exists!");
            }
        } else {
            throw new InsufficientCommandArgumentsEx();
        }
    }

    @Override
    public void undoMe() {
        Company c = Company.getInstance();
        c.removeProject(p);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        Company c = Company.getInstance();
        c.addProject(p);
        addUndoCommand(this);
    }

    public Integer tryParse(String s) {
        Integer result = null;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format for project duration!");
        }
        return result;
    }

}

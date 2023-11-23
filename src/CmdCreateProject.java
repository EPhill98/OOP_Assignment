public class CmdCreateProject extends RecordedCommand {
    private Project p;

    @Override
    public void execute(String[] cmdParts) {
        Company c = Company.getInstance();
        try {
            p = c.createProject(cmdParts[1], cmdParts[2], cmdParts[3]);
        } catch (ProjectAlreadyExists e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
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
    
}

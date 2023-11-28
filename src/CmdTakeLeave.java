public class CmdTakeLeave extends RecordedCommand {
    private Employee e;
    private LeaveDay leaveStart;
    private Day leaveStartCopy;
    private Day leaveEnd;
    private int leaveCount = 1;
    private int oldLeave;

    @Override
    public void execute(String[] cmdParts){
        Company c = Company.getInstance();
        e = c.getEmployee(cmdParts[1]);
        oldLeave = e.getAnnualLeaves();
        leaveStart = new LeaveDay(cmdParts[2]);
        leaveStartCopy = leaveStart;
        leaveEnd = new LeaveDay(cmdParts[3]);
        leaveStart.setStartDay(leaveStart);
        leaveStart.setEndDay(leaveEnd);
        while(!leaveStartCopy.toString().equals(leaveEnd.toString())){
            leaveStartCopy = leaveStartCopy.nextDay();
            leaveCount++;
        }
        e.setAnnualLeaves(e.getAnnualLeaves()-leaveCount);
        e.addLeave(leaveStart);
        addUndoCommand(this);
        clearRedoList();
        String out = String.format("Done. %s's remaining annual leave: %d days  ", 
        e.getName(),e.getAnnualLeaves());
        System.out.println(out);

    }


    @Override
    public void undoMe() {
        Company c = Company.getInstance();
        e.setAnnualLeaves(oldLeave);
        e.deleteLeave();
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        e.setAnnualLeaves(e.getAnnualLeaves()-leaveCount);
        e.addLeave(leaveStart);
        addUndoCommand(this);
    }
    
}

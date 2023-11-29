public class CmdTakeLeave extends RecordedCommand {
    private Employee e;
    private LeaveDay leaveStart;
    private int leaveCount = 1;
    private int oldLeave;

    @Override
    public void execute(String[] cmdParts){
        Company c = Company.getInstance();

        e = c.getEmployee(cmdParts[1]);
        oldLeave = e.getAnnualLeaves();
        leaveStart = new LeaveDay(cmdParts[2]);
        Day leaveStartCopy = leaveStart;
        leaveStart.setStartDay(leaveStart);
        leaveStart.setEndDay(new Day(cmdParts[3]));

        while(!leaveStartCopy.toString().equals(leaveStart.getEndDay().toString())){
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

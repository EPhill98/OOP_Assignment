import java.util.ArrayList;

public class CmdTakeLeave extends RecordedCommand {
    private Employee e;
    private LeaveDay leaveStart;
    private int leaveCount = 1;
    private int oldLeave;

    @Override
    public void execute(String[] cmdParts)
            throws InsufficientCommandArgumentsEx, LeaveOverLappedEX, InsufficientBallanceEx {
        Company c = Company.getInstance();
        if (cmdParts.length != 4) {
            throw new InsufficientCommandArgumentsEx();
        }
        e = c.getEmployee(cmdParts[1]);
        oldLeave = e.getAnnualLeaves();
        leaveStart = new LeaveDay(cmdParts[2]);
        Day leaveStartCopy = leaveStart;
        leaveStart.setStartDay(leaveStart);
        leaveStart.setEndDay(new Day(cmdParts[3]));

        while (!leaveStartCopy.toString().equals(leaveStart.getEndDay().toString())) {
            leaveStartCopy = leaveStartCopy.nextDay();
            leaveCount++;
        }
        if (leaveCount > e.getAnnualLeaves()) {
            throw new InsufficientBallanceEx(e);
        } else {
            try {
                checkDates(e.getTakenLeaave());
                e.setAnnualLeaves(e.getAnnualLeaves() - leaveCount);
                e.addLeave(leaveStart);

                addUndoCommand(this);
                clearRedoList();

                String out = String.format("Done. %s's remaining annual leave: %d days  ",
                        e.getName(), e.getAnnualLeaves());
                System.out.println(out);
            } catch (LeaveOverLappedEX e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void undoMe() {

        e.setAnnualLeaves(oldLeave);
        e.deleteLeave();
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        e.setAnnualLeaves(e.getAnnualLeaves() - leaveCount);
        e.addLeave(leaveStart);
        addUndoCommand(this);
    }

    private void checkDates(ArrayList<LeaveDay> lst) throws LeaveOverLappedEX {

        int startD = LeaveDay.getDateComp(leaveStart.getStartDay());
        int endD = LeaveDay.getDateComp(leaveStart.getEndDay());
        for (LeaveDay d : lst) {
            Day s = d.getStartDay();
            Day e = d.getEndDay();
            int startD2 = LeaveDay.getDateComp(s);
            int endD2 = LeaveDay.getDateComp(e);
            if ((startD > startD2 && startD < endD2) || (endD > startD2 && endD < endD2)
                    || (startD < startD2 && endD > endD2))
                throw new LeaveOverLappedEX(d);
        }
    }
}

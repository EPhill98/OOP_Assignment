public class CmdListTeamMembers implements Command{

    @Override
    public void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx, EmployeeNotFound, TeamAlreadyExistsEx,
            ProjectNotFoundEx, TeamNotFoundEx {
        Company c = Company.getInstance();
        c.findTeam(cmdParts[1]).listMembers();
    }
    
}

interface Command {
    void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx, EmployeeNotFound, TeamAlreadyExistsEx, ProjectNotFoundEx, TeamNotFoundEx, LeaveOverLappedEX, InsufficientBallanceEx, HasJoinedTeamEX;
}

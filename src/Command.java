interface Command {
    void execute(String[] cmdParts) throws InsufficientCommandArgumentsEx;
}

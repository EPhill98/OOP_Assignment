public class HasJoinedTeamEX extends Exception {
    Employee e;
    Team t;

    public HasJoinedTeamEX() {
        super("EMPLOYEE has already joined another team: TEAM");
    }

    public HasJoinedTeamEX(String m) {
        super(m);
    }

    public HasJoinedTeamEX(Employee e, Team t) {
        this.e = e;
        this.t = t;
    }

    @Override
    public String toString() {
        return String.format("%s has already joined another team: %s", e.getName(),e.getTeamName());

    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();

        Scanner inFile = new Scanner(new File(filepathname));

        String cmdLine1 = inFile.nextLine();
        String[] cmdLine1Parts = cmdLine1.split("\\|");
        System.out.println("\n> " + cmdLine1);
        SystemDate.createTheInstance(cmdLine1Parts[1]);

        while (inFile.hasNext()) {
            String cmdLine = inFile.nextLine().trim();

            if (cmdLine.equals(""))
                continue;

            System.out.println("\n> " + cmdLine);

            String[] cmdParts = cmdLine.split("\\|");

            if (cmdParts[0].equals("hire"))
                try {
                    (new CmdHire()).execute(cmdParts);
                } catch (InsufficientCommandArgumentsEx e) {
                    System.out.println(e);
                }
            if (cmdParts[0].equals("listEmployees"))
                (new CmdListEmployees()).execute(cmdParts);
            if (cmdParts[0].equals("setupTeam"))
                try {
                    (new CmdSetUpTeam()).execute(cmdParts);
                } catch (InsufficientCommandArgumentsEx e) {
                    System.out.println(e);
                }
            if (cmdParts[0].equals("listTeams"))
                (new CmdListTeams()).execute(cmdParts);
            if (cmdParts[0].equals("startNewDay"))
                try {
                    (new CmdStartNewDay()).execute(cmdParts);
                } catch (InsufficientCommandArgumentsEx e) {
                    System.out.println(e);
                }
            if (cmdParts[0].equals("createProject"))
                try {
                    (new CmdCreateProject()).execute(cmdParts);
                } catch (InsufficientCommandArgumentsEx e) {
                    System.out.println(e);
                }
            if (cmdParts[0].equals("listProjects"))
                (new CmdListProject()).execute(cmdParts);
            if (cmdParts[0].equals("assign"))
                try {
                    (new CmdAssign()).execute(cmdParts);
                } catch (InsufficientCommandArgumentsEx e) {
                    System.out.println(e);
                } catch (ProjectNotFoundEx e) {
                    System.out.println(e);
                } catch (TeamNotFoundEx e) {
                    System.out.println(e);
                }

            if (cmdParts[0].equals("undo"))
                RecordedCommand.undoOneCommand();
            if (cmdParts[0].equals("redo"))
                RecordedCommand.redoOneCommand();
        }
        inFile.close();

        in.close();

    }
}
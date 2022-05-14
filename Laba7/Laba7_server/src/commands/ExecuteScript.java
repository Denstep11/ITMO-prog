package commands;

import util.ComandInterface;

/**
 * read commands from a file
 */
public class ExecuteScript implements ComandInterface {
    private final static String name = "execute_script";

    /**
     * executes the command
     */
    public static void execute() {
        History.archive.add(name);
    }
}

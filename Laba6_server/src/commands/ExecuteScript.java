package commands;

import util.ComandInterface;
import util.ConsoleControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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

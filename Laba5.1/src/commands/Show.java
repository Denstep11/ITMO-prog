package commands;

import data.HumanBeing;
import util.Collection;
import util.ComandInterface;

import java.util.Scanner;

/**
 * display collection
 */
public class Show implements ComandInterface {
    private final static String name = "show";

    /**
     * executes the command
     * @param scanner input stream
     */
    public static void execute(Scanner scanner) {
        History.archive.add(name);
        for (HumanBeing set : Collection.tree) {
            System.out.println(set);
        }
    }
}

package commands;

import util.Collection;
import util.ComandInterface;

import java.util.Date;
import java.util.Scanner;

/**
 * clear collection
 */
public class Clear implements ComandInterface {
    private final static String name = "clear";

    /**
     * executes the command
     * @param scanner input stream
     */
    public static void execute(Scanner scanner) {
        History.archive.add(name);
        Collection.tree.clear();
        Date date = new Date();
        Collection.modiftime = date.toString();
        System.out.println("Коллекция очищена");
    }
}

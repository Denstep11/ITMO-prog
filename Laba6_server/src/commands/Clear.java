package commands;

import network.Server;
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
     */
    public static void execute() {
        History.archive.add(name);
        Collection.tree.clear();
        Date date = new Date();
        Collection.modiftime = date.toString();
        Server.answer = "Коллекция очищена";
    }
}

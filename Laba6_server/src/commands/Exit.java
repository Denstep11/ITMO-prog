package commands;

import network.Server;
import util.ComandInterface;

/**
 * exit the program
 */
public class Exit implements ComandInterface {
    private final static String name = "exit";
    public static boolean run = true;

    /**
     * executes the command
     */
    public static void execute() {
        run = false;
        Server.answer = "Работа завершена";
    }
}

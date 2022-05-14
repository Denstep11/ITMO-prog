package commands;

import network.Server;
import util.ComandInterface;

/**
 * exit the program
 */
public class Exit implements ComandInterface {
    public static boolean run = true;

    /**
     * executes the command
     */
    public static String execute() {
        String answer;
        run = false;
        answer = "Работа завершена";
        return answer;
    }

}

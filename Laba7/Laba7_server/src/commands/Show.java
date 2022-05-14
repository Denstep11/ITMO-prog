package commands;

import data.HumanBeing;
import network.Server;
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
     */
    public static String execute() {
        String answer;
        History.archive.add(name);
        String ans = "";
        for (HumanBeing set : Collection.tree) {
            ans = ans + set.toString()+"\n";
        }
        answer = ans;
        return answer;
    }
}

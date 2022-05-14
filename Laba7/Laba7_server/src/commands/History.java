package commands;

import network.Server;
import util.ComandInterface;

import java.util.ArrayList;

/**
 * display a list 5 last commands
 */
public class History implements ComandInterface {
    private final static String name = "history";
    public static ArrayList<String> archive = new ArrayList<>();

    /**
     * executes the command
     */
    public static String execute() {
        String answer;
        archive.add(name);
        String ans = "";
        if (archive.size() >= 5) {
            for (int i = archive.size() - 5; i < archive.size(); i++) {
                System.out.println(archive.get(i));
                ans = ans + archive.get(i)+"\n";
            }
            answer = ans;
        } else {
            answer = "Вы использвали только " + archive.size() + " команд";
        }
        return answer;
    }
}

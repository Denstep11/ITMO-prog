package commands;

import util.ComandInterface;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * display a list 5 last commands
 */
public class History implements ComandInterface {
    private final static String name = "history";
    public static ArrayList<String> archive = new ArrayList<>();

    /**
     * executes the command
     * @param scanner input stream
     */
    public static void execute(Scanner scanner) {
        if (archive.size() >= 5) {
            for (int i = archive.size() - 5; i < archive.size(); i++) {
                System.out.println(archive.get(i));
            }
            archive.add(name);
        } else {
            System.out.println("Вы использвали только " + archive.size() + " команд");
        }
    }
}

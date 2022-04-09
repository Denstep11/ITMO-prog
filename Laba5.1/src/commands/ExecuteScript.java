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
     * @param s script address
     */
    public static void execute(String s) {
        History.archive.add(name);
        ConsoleControl consoleControl = new ConsoleControl();
        try {
            FileReader reader = new FileReader(new File(s));
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                consoleControl.choice(scan.nextLine(), scan, false);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка чтения файла, проверьте адрес файла!");
        }
    }
}

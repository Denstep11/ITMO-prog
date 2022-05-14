package commands;

import util.Collection;
import util.ComandInterface;
import util.FileControl;
import util.ParserControl;

import java.util.Scanner;

/**
 * save collection in file
 */
public class Save implements ComandInterface {
    private final static String name = "save";

    /**
     * executes the command
     */
    public static void execute() {
        String answer;
        History.archive.add(name);
        FileControl fileControl = new FileControl();
        ParserControl parserControl = new ParserControl();
        try {
            fileControl.writeln(Collection.address, parserControl.infile(Collection.tree));
            System.out.println("Файл сохранён");
        } catch (Exception ex) {
            System.out.println("Файл не найден");
        }
    }
}

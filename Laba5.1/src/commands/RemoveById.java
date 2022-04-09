package commands;

import util.Collection;
import util.ComandInterface;

import java.util.Date;
import java.util.Scanner;

/**
 * remove element by id in collection
 */
public class RemoveById implements ComandInterface {
    private final static String name = "remove_by_id";

    /**
     * executes the command
     * @param id id element for remove
     * @param scanner input stream
     */
    public static void execute(String id, Scanner scanner) {
        History.archive.add(name);
        if (Collection.tree.removeIf(element -> element.getId() == Long.valueOf(id))) {
            Date date = new Date();
            Collection.modiftime = date.toString();
            System.out.println("Элемент с id:=" + id + " удален");
        } else {
            System.out.println("Элемент с этим id не найден");
        }
    }
}
